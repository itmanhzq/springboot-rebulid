package com.fenlibao.pms.common.sign;

import com.fenlibao.pms.common.redies.RedisPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 保存请求的唯一随机字符串
 *
 * @author LeiXinXin
 * @date 2018/12/3
 */
@Component
public class NonceUtil {

    private static RedisTemplate<String, String> redisTemplate;

    @Autowired
    private NonceUtil(RedisTemplate<String, String> redisTemplate) {
        NonceUtil.redisTemplate = redisTemplate;
    }

    /**
     * 判断随机请求字符串是否存在
     *
     * @param token 用户令牌
     * @param nonce 随机字符串
     * @return boolean
     */
    public static boolean exists(String token, String nonce) {
        String key = String.format("%s%s%s", RedisPrefix.REQUEST_NONCE_PREFIX.getPrefix(), token, nonce);
        Boolean hasKey = redisTemplate.hasKey(key);
        if (Objects.isNull(hasKey)) {
            return false;
        }
        return hasKey.booleanValue();
    }

    /**
     * 保存随机请求字符串
     *
     * @param token 用户令牌
     * @param nonce 随机字符串
     */
    public static void addNonce(String token, String nonce) {
        String key = String.format("%s%s%s", RedisPrefix.REQUEST_NONCE_PREFIX.getPrefix(), token, nonce);
        long expired = 180;
        redisTemplate.opsForValue().set(key, nonce, expired, TimeUnit.SECONDS);
    }
}
