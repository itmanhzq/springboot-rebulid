package com.fenlibao.xinwang.config;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Flynn
 * @date 2018/11/19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String PRO = "pro";
    private static final String ACCESS_KEY = "accessKey";
    private static final String PACKAGE = "com.fenlibao.xinwang.controller";


    @Bean
    public Docket api(Environment env) {
        String[] activeProfiles = env.getActiveProfiles();
        if (ArrayUtil.isNotEmpty(activeProfiles) && activeProfiles[0].equalsIgnoreCase(PRO)) {
            return getProDocket();
        }
        return getInternalDocket();
    }

    private List<Parameter> getParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(getHeaderParameter(ACCESS_KEY, "接入密钥，每个微服务独立密钥，不要共用"));
        return parameters;
    }

    private Parameter getHeaderParameter(String headerName, String description) {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder
                .name(headerName)
                .description(description)
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .build();
        return parameterBuilder.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("新网微服务-API")
                .version("0.0.1-SNAPSHOT")
                .build();
    }

    private Docket getInternalDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getParameters())
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
