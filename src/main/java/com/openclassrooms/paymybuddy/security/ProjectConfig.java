package com.openclassrooms.paymybuddy.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter
{
    private final AuthenticationProviderService authenticationProvider;

    public ProjectConfig(AuthenticationProviderService authenticationProvider)
    {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
    {
        auth.authenticationProvider(authenticationProvider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        String[] allowedGetRestController={"/api/connections/all"};

        String[] allowedPostRestController={"/api/clients/new"};

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.OPTIONS, "/api/basicAuth/**").permitAll()
                .mvcMatchers("/api/basicAuth/**").permitAll()
                .mvcMatchers(HttpMethod.GET,  allowedGetRestController).permitAll()
                .mvcMatchers(HttpMethod.POST, allowedPostRestController).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        http.csrf().disable();
    }
}