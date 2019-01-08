package com.fenlibao.pms.config;

import com.fenlibao.pms.security.CustomUserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.authentication.CachingUserDetailsService;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * UserDetailsCacheConfig
 *
 * @author chen
 * @date 2019/1/3
 */
@Slf4j
@Component
public class UserDetailsCacheConfig {
    private static final String CACHE_NAME = "userCache";
    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    @Bean
    public UserCache userCache() {
        try {
            EhCacheBasedUserCache userCache = new EhCacheBasedUserCache();
            val cacheManager = CacheManager.getInstance();
            val cache = cacheManager.getCache(CACHE_NAME);
            userCache.setCache(cache);
            return userCache;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        Constructor<CachingUserDetailsService> ctor = null;
        try {
            ctor = CachingUserDetailsService.class.getDeclaredConstructor(UserDetailsService.class);
            ctor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            log.error("[UserDetailsCacheConfig.userDetailsService]", e);
        }

        CachingUserDetailsService cachingUserDetailsService = BeanUtils.instantiateClass(ctor, customUserDetailsService);
        cachingUserDetailsService.setUserCache(userCache());
        return cachingUserDetailsService;
    }
}
