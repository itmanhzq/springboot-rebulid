package com.fenlibao.pms.config;

import com.fenlibao.pms.security.CustomUserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.authentication.CachingUserDetailsService;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;

import java.lang.reflect.Constructor;


@Slf4j
@Configuration
public class UserDetailsCacheConfig {
    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsService;

    private static  final  String CACHE_NAME = "userCache";

    @Bean
    public UserCache userCache(){
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
    public UserDetailsService userDetailsService(){
        Constructor<CachingUserDetailsService> ctor = null;
        try {
            ctor = CachingUserDetailsService.class.getDeclaredConstructor(UserDetailsService.class);
        } catch (NoSuchMethodException e) {
            log.error("[UserDetailsCacheConfig.userDetailsService]",e);
        }
        ctor.setAccessible(true);

        CachingUserDetailsService cachingUserDetailsService = BeanUtils.instantiateClass(ctor, customUserDetailsService);
        cachingUserDetailsService.setUserCache(userCache());
        return cachingUserDetailsService;
    }
}
