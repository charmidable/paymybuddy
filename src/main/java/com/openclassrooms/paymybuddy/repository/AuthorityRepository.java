package com.openclassrooms.paymybuddy.repository;


import com.openclassrooms.paymybuddy.Entities.Authority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer>
{

}

