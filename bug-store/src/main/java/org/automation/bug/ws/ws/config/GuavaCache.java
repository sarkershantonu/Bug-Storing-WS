package org.automation.bug.ws.ws.config;

import org.springframework.context.annotation.Configuration;

//@Configuration
public class GuavaCache {
/*    @Bean
    public CacheManager cacheManager(){
//GuavaCacheManager removed in spring boot 2
        return new GuavaCacheManager("bugs");
    }
    public CacheManager cacheManagerExplicit(){

        GuavaCacheManager cache  = new GuavaCacheManager("bugs");
        CacheBuilder<Object, Object> builder = CacheBuilder
                .newBuilder()
                .maximumSize(500)
                .expireAfterWrite(30, TimeUnit.SECONDS);
        cache.setCacheBuilder(builder);
        return cache;
    }*/
}
