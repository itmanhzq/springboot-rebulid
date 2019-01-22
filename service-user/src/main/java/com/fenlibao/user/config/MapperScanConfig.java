package com.fenlibao.user.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 * @date 2019/01/13
 */
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.fenlibao.user.mapper")
public class MapperScanConfig {
}
