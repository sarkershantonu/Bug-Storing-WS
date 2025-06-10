package org.automation.bug.ws.ws.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class WsbSecConfig {

    @Value("${security.user.name}")
    private String user;
    @Value("${security.user.password}")
    private String pass;
    @Bean
    public SecurityFilterChain disableCsrf(HttpSecurity http) throws Exception {
        //.antMatchers("/table/bugs/**"). permitAll();
        http.csrf((csrf)-> csrf.disable());
        return http.build();
    }
}
