package org.automation.bug.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.function.BiFunction;

/**
 * Created by shantonu on 12/18/16.
 */
@EnableTransactionManagement
@EnableCaching
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Bug storing web service is running");
    }

    @Bean
    public CacheManager cacheManager(){
//GuavaCacheManager removed in spring boot 2
        return new GuavaCacheManager("bugs");
    }

    public <K,V> void Compute(K key, BiFunction<?super K, ? super V, ? extends V> remappingFunction){

    }

}
