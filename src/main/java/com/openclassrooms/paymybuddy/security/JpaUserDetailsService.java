package com.openclassrooms.paymybuddy.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUserDetailsService  implements UserDetailsService
{
    private final ClientRepository clientRepository;


    public JpaUserDetailsService(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }


    @Override
    @Transactional
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Client client = clientRepository.findClientByEmail(username)
                                        .orElseThrow(() -> new UsernameNotFoundException("Problem during authentication!"));

        return new SecurityUser(client);
    }
}