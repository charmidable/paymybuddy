package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.dto.AngularTransaction;
import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.entities.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class RestService
{
    private final TransactionService transactionService;
    private final AccountService accountService;

    public RestService(TransactionService transactionService, AccountService accountService)
    {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @Transactional
    public void save(AngularTransaction angularTransaction)
    {
        if(angularTransaction.payerAccountId() != angularTransaction.recipientAccountId())
        {
            Account payerAccount = accountService.getAccountById(angularTransaction.payerAccountId()).get();
            Account recipientAccount = accountService.getAccountById(angularTransaction.recipientAccountId()).get();

            Transaction transaction = new Transaction(angularTransaction.amount(), angularTransaction.description(), payerAccount, recipientAccount);
            payerAccount.setBalance(payerAccount.getBalance().subtract(angularTransaction.amount().multiply(BigDecimal.valueOf(1.05))));
            recipientAccount.setBalance(recipientAccount.getBalance().add(angularTransaction.amount()));

            transactionService.save(transaction);
            accountService.save(payerAccount);
            accountService.save(recipientAccount);
        }
        else
        {
            Account payerAccount = accountService.getAccountById(angularTransaction.payerAccountId()).get();

            Transaction transaction = new Transaction(angularTransaction.amount(), angularTransaction.description(), payerAccount, payerAccount);
            payerAccount.setBalance(payerAccount.getBalance().subtract(angularTransaction.amount()));

            transactionService.save(transaction);
            accountService.save(payerAccount);
        }
    }
}