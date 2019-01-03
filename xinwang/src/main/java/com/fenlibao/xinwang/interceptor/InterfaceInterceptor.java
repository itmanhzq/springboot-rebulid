package com.fenlibao.xinwang.interceptor;

import com.fenlibao.xinwang.mapper.InterfacePrivilegeMapper;
import com.fenlibao.xinwang.model.enums.RequestHeaderEnum;
import com.fenlibao.xinwang.model.po.InterfacePrivilege;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 接口权限拦截器
 * @author Administrator
 */
@Slf4j
public class InterfaceInterceptor implements HandlerInterceptor  {


    private static final String XINWANG = "xinwang";

    @Autowired
    private InterfacePrivilegeMapper interfacePrivilegeMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String access = request.getHeader(RequestHeaderEnum.ACCESS_KEY.getValue());
        if (request.getRequestURI().contains(XINWANG)) {
            InterfacePrivilege privilege = interfacePrivilegeMapper.selectByPrimaryKey(access);
            if(privilege==null){
                throw  new Exception("无调用接口权限，请传输正确的accessKey:"+access);
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

}
