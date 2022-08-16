package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.Entities.Account;
import com.openclassrooms.paymybuddy.Entities.Client;
import com.openclassrooms.paymybuddy.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAccounts()
    {
        return accountRepository.findAll();
    }
}
