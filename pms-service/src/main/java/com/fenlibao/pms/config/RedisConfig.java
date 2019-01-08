package com.fenlibao.pms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Toby
 * @date 2018/11/13
 */
@Configuration
public class RedisConfig {
    @Autowired
    Environment env;

    @Bean(name = "redisTemplate")
    RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory rcf) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(rcf);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericJackson2JsonRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }
}
