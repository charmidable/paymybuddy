package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.entities.Authority;
import com.openclassrooms.paymybuddy.repository.AuthorityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorityService
{
    //=========================
    //=      Attributes       =
    //=========================
    private final AuthorityRepository authorityRepository;

    //=========================
    //=      Constructor      =
    //=========================
    public AuthorityService(AuthorityRepository authorityRepository)
    {
        this.authorityRepository = authorityRepository;
    }

    //=========================
    //=  Repository Methods   =
    //=========================
    public Optional<Authority> findAuthorityByName(String name)
    {
        return authorityRepository.findAuthorityByName(name);
    }
}
