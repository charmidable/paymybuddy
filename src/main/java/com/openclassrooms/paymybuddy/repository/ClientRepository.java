package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.Entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>
{
}