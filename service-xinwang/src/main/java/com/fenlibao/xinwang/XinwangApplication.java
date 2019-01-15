package com.fenlibao.xinwang;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author Flynn
 */
@SpringBootApplication
@EnableTransactionManagement
public class XinwangApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinwangApplication.class, args);
    }

    @Bean("objectMapper")
    public ObjectMapper myMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }


}
