package com.fenlibao.pms.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 构建cors请求头允许跨域参数
 * @author chen
 * @date 2018/12/19
 */
@Configuration
@AutoConfigureBefore(SecurityConfig.class)
public class CorsConfigurer implements WebMvcConfigurer {

    @Autowired
    private Config config;

    private static final String MAPPING_URL = "/**";

    private static final int MAX_AGE = 600;

    private static final boolean CREDENTIALS = true;

    private static final String ALLOW_ALL = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping(MAPPING_URL)
                .allowedOrigins(config.getOrigin())
                .allowedMethods(ALLOW_ALL)
                .allowedHeaders(ALLOW_ALL)
                .allowCredentials(CREDENTIALS)
                .maxAge(MAX_AGE);
    }
}
