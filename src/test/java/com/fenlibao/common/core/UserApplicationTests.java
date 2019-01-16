package com.fenlibao.common.core;

import cn.hutool.core.lang.Assert;
import com.fenlibao.user.UserApplication;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@Slf4j
public class UserApplicationTests {

    @Autowired
    StringEncryptor stringEncryptor;

    @Autowired
    Environment env;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEncryptPassword() {
        String dbPasswordKey = "spring.datasource.password";
        String encryptDBPassword = stringEncryptor.encrypt(env.getProperty(dbPasswordKey));
       // String encryptDBPassword = stringEncryptor.encrypt("123456");
        log.info("db passwd: {}", encryptDBPassword);
        Assert.isTrue(stringEncryptor.decrypt(encryptDBPassword).equalsIgnoreCase(env.getProperty(dbPasswordKey)));;
        //log.info(stringEncryptor.decrypt(encryptDBPassword));
        log.info("redis passwd: {}", stringEncryptor.encrypt("123456"));
        log.info("app jwtSecret: {}", stringEncryptor.encrypt("123456"));
    }

}

