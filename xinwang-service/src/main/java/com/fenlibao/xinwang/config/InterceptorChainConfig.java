package com.fenlibao.xinwang.config;


import com.fenlibao.xinwang.interceptor.InterfaceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器链
 *
 * @author Flynn
 * @date 2018/11/14
 */
@Configuration
public class InterceptorChainConfig implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor interfaceInterceptor() {
        return new InterfaceInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interfaceInterceptor()).addPathPatterns("/**");
    }
}
