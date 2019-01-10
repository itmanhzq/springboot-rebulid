package com.fenlibao.bid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 标的服务启动类
 *
 * @author LeiXinXin
 * @date 2019/1/3
 */
@SpringBootApplication
@EnableTransactionManagement
public class BidApplication {

    public static void main(String[] args) {
        SpringApplication.run(BidApplication.class, args);
    }
}
