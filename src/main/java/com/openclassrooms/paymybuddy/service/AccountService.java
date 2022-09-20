package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.entities.Transaction;
import com.openclassrooms.paymybuddy.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

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

    public Optional<Account> getAccountById(Integer id)
    {
       return accountRepository.findById(id);
    }

    public void save(Account account)
    {
        accountRepository.save(account);
    }
}
