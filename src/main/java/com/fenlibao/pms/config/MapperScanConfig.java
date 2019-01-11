package com.fenlibao.pms.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Toby
 * @date 2018/11/13
 */
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.fenlibao.pms.mapper")
public class MapperScanConfig {
}
