package com.fenlibao.pms.service.impl;

import com.fenlibao.common.core.redis.RedisPrefix;
import com.fenlibao.pms.service.TokenService;
import lombok.val;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author chen
 * @date 2018/12/11
 */
@Service("TokenService")
public class TokenServiceImpl implements TokenService {


    private static final long MAX_TIME = 20;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String CACHE_NAME = "userCache";

    @Override
    public void saveTokenToReids(Integer userId, String token) {
        redisTemplate.opsForValue().set(RedisPrefix.USER_TOKEN.getPrefix() + ":" + userId, token, MAX_TIME, TimeUnit.MINUTES);
    }

    @Override
    public boolean checkToken(Integer userId, String token) {
        String redisToken = String.valueOf(redisTemplate.boundValueOps(RedisPrefix.USER_TOKEN.getPrefix() + ":" + userId).get());
        if (redisToken == null || !redisToken.equals(token)) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisTemplate.boundValueOps(RedisPrefix.USER_TOKEN.getPrefix() + ":" + userId).expire(MAX_TIME, TimeUnit.MINUTES);
        return true;
    }

    @Override
    public void deleteCache(String userName) throws Exception {
        EhCacheBasedUserCache userCache = new EhCacheBasedUserCache();
        val cacheManager = CacheManager.getInstance();
        val cache = cacheManager.getCache(CACHE_NAME);
        userCache.setCache(cache);
        userCache.removeUserFromCache(userName);
    }
}
