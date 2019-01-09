package com.fenlibao.pms.interceptor;

import cn.hutool.extra.servlet.ServletUtil;
import com.fenlibao.pms.common.http.RequestUtil;
import com.fenlibao.pms.config.Config;
import com.fenlibao.pms.security.JwtTokenProvider;
import com.fenlibao.pms.service.system.RequestLogService;
import com.fenlibao.pms.model.bo.idmt.RequestLogBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Toby
 * @date 2018/11/14
 */
@Slf4j
public class TraceInterceptor implements HandlerInterceptor {
    private static final String ROOT_PATH = "/";
    private static final String SESSION_LOG_KEY = "REQUEST_LOG";

    @Autowired
    RequestLogService requestLogService;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    private Config config;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if (!excludeURI(request.getRequestURI())) {
            log.info("path - {} trace preHandle", request.getRequestURI());
            RequestLogBO requestLogBO = new RequestLogBO();
            requestLogBO.setIp(ServletUtil.getClientIP(request));
            requestLogBO.setUrl(request.getRequestURI());
            requestLogBO.setStartTime(System.currentTimeMillis());
            requestLogBO.setReqContent(ServletUtil.getBody(request));
            request.getSession().setAttribute(SESSION_LOG_KEY, requestLogBO);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {
        if (!excludeURI(request.getRequestURI())) {
            log.info("path - {} trace postHandle", request.getRequestURI());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) {
        if (!excludeURI(request.getRequestURI())) {
            log.info("path - {} trace postHandle", request.getRequestURI());
            Object object = request.getSession().getAttribute(SESSION_LOG_KEY);
            if (Objects.isNull(object)) {
                log.info("请求日志不存在");
                return;
            }
            if (object instanceof RequestLogBO) {
                RequestLogBO reqLog = (RequestLogBO) object;
                String jwt = RequestUtil.getJwtFromRequest(request);
                if (!StringUtils.isEmpty(jwt)) {
                    reqLog.setUserId(tokenProvider.getUserIdFromJWT(jwt));
                }
                reqLog.setEndTime(System.currentTimeMillis());
                requestLogService.saveLog(reqLog);
            } else {
                log.error("请求日志类型错误:{}", object.getClass().toString());
            }
        }
    }

    private boolean excludeURI(String requestURI) {
        List<String> excludeUri =Arrays.asList(config.getExcludeUri());
        excludeUri.contains(requestURI);
        return excludeUri.stream().anyMatch(requestURI::contains) || requestURI.trim().equals(ROOT_PATH);
    }
}
