package com.openclassrooms.paymybuddy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer
{
    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/api/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
//                .allowedOrigins("http://localhost:4200");
                .allowedOrigins("*");
    }
}


//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        String[] allowedGetRestController={"/api/connections", "/api/basicAuth/validate"};
//
//        String[] allowedPostRestController={"/api/clients"};
//
//        http.authorizeRequests()
//                .mvcMatchers(HttpMethod.GET,  allowedGetRestController).permitAll()
//                .mvcMatchers(HttpMethod.POST, allowedPostRestController).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        http.csrf().disable();
//    }