package com.openclassrooms.paymybuddy.repository;

import org.springframework.data.jpa.repository.Query;
import com.openclassrooms.paymybuddy.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends CrudRepository<Client, Integer>
{
    @Query(value ="INSERT INTO connection (client, connect) VALUES (?1, ?2)" , nativeQuery = true)
    void addConnection(Integer clientId , Integer connectId );

    Optional<Client> findClientByEmail(String username);
}