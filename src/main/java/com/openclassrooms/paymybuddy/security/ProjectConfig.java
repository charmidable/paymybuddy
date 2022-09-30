package com.openclassrooms.paymybuddy.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

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
        http.authorizeRequests()
            .mvcMatchers("/api/**")
            .permitAll()//.anyRequest().authenticated()
            .and().httpBasic();

        http.csrf().disable();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.cors(
//                c -> {
//                    CorsConfigurationSource source = request -> {
//                        CorsConfiguration config = new CorsConfiguration();
//                        config.setAllowedOrigins(List.of("*"));
//                        config.setAllowedMethods(List.of("*"));
//                        return config;
//                    };
//                    c.configurationSource(source);
//                }
//        );
//
//        http.csrf().disable();
//
//        http.authorizeRequests().anyRequest().permitAll();
//    }


}