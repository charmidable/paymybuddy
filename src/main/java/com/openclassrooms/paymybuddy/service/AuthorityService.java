package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService
{
    private  final AccountRepository accountRepository;


    public AuthorityService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }
}
