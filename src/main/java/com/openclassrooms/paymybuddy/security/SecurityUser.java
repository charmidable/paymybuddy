package com.openclassrooms.paymybuddy.security;

import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.entities.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collection;

public class SecurityUser implements UserDetails
{
    private final Client client;

    public Client getClient()
    {
        return client;
    }

    public SecurityUser(Client client)
    {
        this.client = client;
    }

    @Override
    public String getUsername()
    {
        return client.getEmail();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    @Override
    public String getPassword()
    {
        return client.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return client.getRoles()
                     .stream()
                     .map(Authority::getName)
                     .map(SimpleGrantedAuthority::new)
                     .toList();
    }
}