package org.automation.bug.ws.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

public class GuavaCache {
    @Bean
    public CacheManager cacheManager(){
//GuavaCacheManager removed in spring boot 2
        return new GuavaCacheManager("bugs");
    }
    public CacheManager cacheManagerExplicit(){

        GuavaCacheManager cache  = new GuavaCacheManager("bugs");
        CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(500).expireAfterWrite(30, TimeUnit.SECONDS);
        cache.setCacheBuilder(builder);
        return cache;
    }
}
