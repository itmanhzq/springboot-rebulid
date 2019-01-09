package com.fenlibao.marketing.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Toby
 * @date 2018/11/13
 */
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.fenlibao.marketing.mapper")
public class MapperScanConfig {
}
