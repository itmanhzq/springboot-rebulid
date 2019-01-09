package com.fenlibao.pms.security;

import com.fenlibao.base.dto.Response;
import com.fenlibao.common.core.WrappedHttpServletRequest;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.common.http.ResponseUtil;
import com.fenlibao.pms.common.json.Jackson;
import com.fenlibao.pms.dto.base.ResponseStatus;
import com.fenlibao.pms.mapper.system.UserDao;
import com.fenlibao.pms.service.TokenService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Toby
 * @date 2018/11/3
 */
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = RequestUtil.getJwtFromRequest(request);
            // 解决request中的流只能使用一次的问题
            if (!(request instanceof WrappedHttpServletRequest)) {
                request = new WrappedHttpServletRequest(request);
            }
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                Integer userId = tokenProvider.getUserIdFromJWT(jwt);
                /// 校验redis的token
                if (!tokenService.checkToken(userId, jwt)) {
                    Response resp = Response.error(ResponseStatus.COMMON_NOT_VALID_TOKEN);
                    ResponseUtil.response(Jackson.getBaseJsonData(resp), response);
                    return;
                }
                String userName = userDao.selectByPrimaryKey(userId).getUserName();
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ExpiredJwtException ex) {
            Response resp = Response.error(ResponseStatus.COMMON_NOT_VALID_EXPIRED);
            ResponseUtil.response(Jackson.getBaseJsonData(resp), response);
            return;
        } catch (Exception ex) {
            log.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }
}
