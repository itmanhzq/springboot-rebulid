package com.fenlibao.marketing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * @author Toby
 * @date 2018/11/29
 */
@Data
@Component
@ConfigurationProperties(prefix = "marketing")
public class Config {
    /**
     * 可访问网址
     */
    @NotBlank
    private String[] permitUrls;
}
