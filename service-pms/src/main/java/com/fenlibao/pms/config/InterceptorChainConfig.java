package com.fenlibao.pms.config;

import com.fenlibao.pms.interceptor.RequestValidateInterceptor;
import com.fenlibao.pms.interceptor.TraceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器链
 *
 * @author Toby
 * @date 2018/11/14
 */
@Configuration
public class InterceptorChainConfig implements WebMvcConfigurer {

    @Autowired
    private Config config;

    /**
     * 让拦截器bean提前加载否者 @Autowired 对象为空
     *
     * @return
     */
    @Bean
    public HandlerInterceptor traceInterceptor() {
        return new TraceInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(traceInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new RequestValidateInterceptor())
                .addPathPatterns("/**")
                // url放行
                .excludePathPatterns(config.getSecurityUrls())
                .excludePathPatterns(config.getSwaggerUrls());
    }
}
