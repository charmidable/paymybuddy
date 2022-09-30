package com.openclassrooms.paymybuddy.repository;


import com.openclassrooms.paymybuddy.entities.Connection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer>
{
    List<Connection> findAll();

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO connection (client, connect) VALUES (?1, ?2)" , nativeQuery = true)
    void addConnection(Integer clientId , Integer connectId);
}