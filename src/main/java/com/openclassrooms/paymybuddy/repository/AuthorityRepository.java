package com.openclassrooms.paymybuddy.repository;


import com.openclassrooms.paymybuddy.entities.Authority;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer>
{
    Optional<Authority> findAuthorityByName(String authorityByName);

    @Transactional
    @Modifying
    @Query(value ="INSERT INTO  role(client, authority) VALUES (?1, ?2)" , nativeQuery = true)
    void addClientAuthority(Integer clientId , Integer authorityId);
}

