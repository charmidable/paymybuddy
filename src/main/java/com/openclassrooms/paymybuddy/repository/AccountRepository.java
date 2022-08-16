package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.Entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>
{

}
