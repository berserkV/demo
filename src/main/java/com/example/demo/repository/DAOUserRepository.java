package com.example.demo.repository;

import com.example.demo.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOUserRepository extends CrudRepository<DAOUser, Integer> {
    public DAOUser findByUsername(String username);
}