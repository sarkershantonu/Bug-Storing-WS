package org.automation.bug.ws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MethodConfig  {

    public WebMvcConfigurer allowedMethod(){
        return new WebMvcConfigurer(){

            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**")
                        .allowCredentials(true)
                        .allowedOrigins("*.*")
                        .allowedMethods("POST,GET,PUT,DELETE");
            }
        };
    }
}
