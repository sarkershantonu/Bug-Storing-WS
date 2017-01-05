package org.automation.bug.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by shantonu on 1/4/17.
 * read property ref : http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Value("${security.user.name}")
    private String user;
    @Value("${security.user.password}")
    private String pass;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/table/bugs/**").permitAll().
                anyRequest().authenticated();
        http.csrf().disable();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(user).password(pass).roles("admin");
    }

}
