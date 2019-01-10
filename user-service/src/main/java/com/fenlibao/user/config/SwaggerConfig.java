package com.fenlibao.user.config;

import cn.hutool.core.util.ArrayUtil;
import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2019/01/03
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String PRO = "pro";

    @Autowired
    Environment env;

    @Bean
    public Docket api() {
        String[] activeProfiles = env.getActiveProfiles();
        if (ArrayUtil.isNotEmpty(activeProfiles) && activeProfiles[0].equalsIgnoreCase(PRO)) {
            return getProDocket();
        }
        return getInternalDocket();
    }

    private Docket getInternalDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fenlibao.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private Docket getProDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.none())
                .paths(PathSelectors.none())
                .build();
    }
}
