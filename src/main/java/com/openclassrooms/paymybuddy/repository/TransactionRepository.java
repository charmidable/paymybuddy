package com.openclassrooms.paymybuddy.repository;


import com.openclassrooms.paymybuddy.Entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
}
