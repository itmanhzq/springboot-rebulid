package com.fenlibao.pms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author WangBoRan
 * @date 2019/1/16
 */
@Data
@Component
@ConfigurationProperties(prefix = "service")
public class ServiceConfig {
}
