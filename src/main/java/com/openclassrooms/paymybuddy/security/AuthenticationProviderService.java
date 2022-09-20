package com.openclassrooms.paymybuddy.security;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthenticationProviderService implements AuthenticationProvider
{
    private final JpaUserDetailsService jpaUserDetailsService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthenticationProviderService(JpaUserDetailsService jpaUserDetailsService)
    {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        System.out.println("*** authenticate *** authenticate *** authenticate *** authenticate ***");

        String username = authentication.getName();

        System.out.println("*** username = " + username );

        String password = authentication.getCredentials().toString();

        SecurityUser user = jpaUserDetailsService.loadUserByUsername(username);

        return checkPassword(user, password);
    }

    @Override
    public boolean supports(Class<?> aClass)
    {
        System.out.println("*** supports *** supports *** supports *** supports ***");

        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

    @Transactional
    Authentication checkPassword(SecurityUser user, String rawPassword)
    {
        System.out.println("*** checkPassword *** checkPassword *** checkPassword *** checkPassword ***");
        if (encoder.matches(rawPassword, user.getPassword()))
        {
            System.out.println("*-*-*-* PASSWORD IS OK *-*-*-*");
            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
        }
        else
        {
            System.out.println("*** Authentification Failed *** Authentification Failed *** Authentification Failed *** ");
            throw new BadCredentialsException("Bad credentials");
        }
    }
}