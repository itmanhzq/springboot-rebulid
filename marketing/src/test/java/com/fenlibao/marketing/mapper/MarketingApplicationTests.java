package com.fenlibao.marketing.mapper;

import cn.hutool.core.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Toby
 * @date 2018/11/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MarketingApplicationTests {

    @Autowired
    StringEncryptor stringEncryptor;

    @Autowired
    Environment env;

    @Test
    public void testEncryptPassword() {
        String dbPasswordKey = "spring.datasource.password";
        String encryptDBPassword = stringEncryptor.encrypt(env.getProperty(dbPasswordKey));
        log.info("db passwd: {}", encryptDBPassword);
        Assert.isTrue(stringEncryptor.decrypt(encryptDBPassword).equalsIgnoreCase(env.getProperty(dbPasswordKey)));
        //log.info(stringEncryptor.decrypt(encryptDBPassword));
        log.info("redis passwd: {}", stringEncryptor.encrypt(env.getProperty("spring.redis.password")));
        log.info("app jwtSecret: {}", stringEncryptor.encrypt(env.getProperty("app.jwtSecret")));
    }
}
