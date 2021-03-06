package com.fenlibao.pms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Toby
 * @date 2018/11/3
 */
@SpringBootApplication
@EnableTransactionManagement
public class PmsApplication {

	public static void main(String[] args) {

		SpringApplication.run(PmsApplication.class, args);
	}

	@Bean("objectMapper")
	public ObjectMapper myMapper() {
		return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}
}
