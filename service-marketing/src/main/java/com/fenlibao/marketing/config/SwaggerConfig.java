package com.fenlibao.marketing.config;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author Toby
 * @date 2018/11/19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String PRO = "pro";
    private static final String PACKAGE = "com.fenlibao.marketing.controller";

    @Bean
    public Docket api(Environment env) {
        String[] activeProfiles = env.getActiveProfiles();
        if (ArrayUtil.isNotEmpty(activeProfiles) && activeProfiles[0].equalsIgnoreCase(PRO)) {
            return getProDocket();
        }
        return getInternalDocket();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Marketing-API")
                .version("0.0.1-SNAPSHOT")
                .build();
    }

    private Docket getInternalDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private Docket getProDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.none())
                .paths(PathSelectors.none())
                .build();
    }
}
