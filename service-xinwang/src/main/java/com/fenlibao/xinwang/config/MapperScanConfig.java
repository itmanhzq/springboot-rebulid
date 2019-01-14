package com.fenlibao.xinwang.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Flynn
 * @date 2018/11/13
 */
@Configuration
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.fenlibao.xinwang.mapper")
public class MapperScanConfig {
}
