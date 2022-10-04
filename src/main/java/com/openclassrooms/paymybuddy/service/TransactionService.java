package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.entities.Transaction;
import com.openclassrooms.paymybuddy.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService
{
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository)
    {
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction)
    {
        return transactionRepository.save(transaction);
    }
}