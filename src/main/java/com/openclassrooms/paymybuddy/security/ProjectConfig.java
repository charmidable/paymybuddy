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


//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        String[] allowedGetRestController={"/api/test/testget"};
//
//        String[] allowedPostRestController={"/api/test/testpost"};
//
//        http.authorizeRequests()
//            .mvcMatchers(HttpMethod.GET,  allowedGetRestController).permitAll()
//            .mvcMatchers(HttpMethod.POST, allowedPostRestController).permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//
//        http.csrf().disable();
//    }


//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.authorizeRequests()
//            .mvcMatchers("/api/**").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//
//        http.csrf().disable();
//    }




//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        String[] allowedGetRestController={"/api/connections", "/api/basicAuth/validate"};
//
//        String[] allowedPostRestController={"/api/clients"};
//
//        http.authorizeRequests()
//                .mvcMatchers(HttpMethod.GET,  "/api/connections").permitAll()
//                .mvcMatchers(HttpMethod.GET,  "/api/basicAuth/validate").permitAll()
//                .mvcMatchers(HttpMethod.POST, "/api/clients").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        http.csrf().disable();
//    }



    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        String[] allowedGetRestController={"/api/connections/all"/*, "/api/basicAuth/validate"*/};

        String[] allowedPostRestController={"/api/clients/new"};

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.OPTIONS, "/api/basicAuth/**").permitAll()
                .mvcMatchers("/api/basicAuth/**").permitAll()
                .mvcMatchers(HttpMethod.GET,  allowedGetRestController).permitAll()
                .mvcMatchers(HttpMethod.POST, allowedPostRestController).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();



//        http.csrf().disable();
    }




//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.authorizeRequests()
//            .mvcMatchers("/api/**").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//
//        http.csrf().disable();
//    }



//    @Override
//    protected void configure(HttpSecurity http) throws Exception
//    {
//        http.authorizeRequests()
//            .mvcMatchers(HttpMethod.GET,  "api/test/testget").permitAll()
//            .mvcMatchers(HttpMethod.POST, "api/test/testpost").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .httpBasic();
//
//        http.csrf().disable();
//    }


//    String[] allowedEndPoint = {"api/connections", };

//     httpSecurity.authorizeRequests()
//             .antMatchers(HttpMethod.GET)
//                    .permitAll() // Allow all GET requests to go unauthenticated
//                    .antMatchers(allowedResources)
//                    .permitAll() // Allow all requests to go unauthenticated for the specified paths
//                    .antMatchers(protectedResources).hasRole(USER)
//                    .antMatchers(adminResources).hasRole(ADMIN)
//                    .anyRequest().authenticated(); // Authenticate all other request paths

}