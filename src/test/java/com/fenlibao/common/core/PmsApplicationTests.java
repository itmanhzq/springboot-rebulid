package com.fenlibao.common.core;

import cn.hutool.core.lang.Assert;
import com.fenlibao.pms.PmsApplication;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Toby
 * @date 2018/11/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PmsApplication.class)
@Slf4j
public class PmsApplicationTests {

    @Autowired
    StringEncryptor stringEncryptor;

    @Autowired
    Environment env;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEncryptPassword() {
        String encrypt = stringEncryptor.encrypt("fenlibao.123");
        String decrypt = stringEncryptor.decrypt(encrypt);

        String a =passwordEncoder.encode("passwd");
        String dbPasswordKey = "spring.datasource.password";
        String encryptDBPassword = stringEncryptor.encrypt(env.getProperty(dbPasswordKey));
        log.info("db passwd: {}", encryptDBPassword);
        Assert.isTrue(stringEncryptor.decrypt(encryptDBPassword).equalsIgnoreCase(env.getProperty(dbPasswordKey)));
        //log.info(stringEncryptor.decrypt(encryptDBPassword));
        log.info("redis passwd: {}", stringEncryptor.encrypt(env.getProperty("spring.redis.password")));
        log.info("app jwtSecret: {}", stringEncryptor.encrypt(env.getProperty("app.jwtSecret")));
    }
}
