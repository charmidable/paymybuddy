package com.openclassrooms.paymybuddy.repository;


import com.openclassrooms.paymybuddy.entities.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Integer>
{
    List<Connection> findAll();
}