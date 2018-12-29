package com.fenlibao.pms.config;

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
 * @author Toby
 * @date 2018/11/19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String PRO = "pro";

    @Autowired
    Environment env;

    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket api() {
        String[] activeProfiles = env.getActiveProfiles();
        if (ArrayUtil.isNotEmpty(activeProfiles) && activeProfiles[0].equalsIgnoreCase(PRO)) {
            return getProDocket();
        }
        return getInternalDocket();
    }

    private List<Parameter> getParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(getHeaderParameter("nonce", "请求头随机字符串"));
        parameters.add(getHeaderParameter("timestamp", "请求头时间戳"));
        parameters.add(getHeaderParameter("Authorization", "请求头令牌"));
        parameters.add(getHeaderParameter("sign", "请求头签名"));
        return parameters;
    }

    private Parameter getHeaderParameter(String headerName, String description) {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder.name(headerName).description(description)
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(true).build();
        return parameterBuilder.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("PMS-API")
                .description("可点击下面（Terms of service）链接生成相关参数,然后在本页调用相关接口进行测试")
                .version("0.0.1-SNAPSHOT")
                .termsOfServiceUrl("http://192.168.40.227:7801")
                .contact(new Contact("Toby","-","toby.xiong@qq.com"))
                .build();
    }

    private Docket getInternalDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fenlibao.pms.controller"))
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
