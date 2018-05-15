package com.model.repository;

import com.model.entity.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Id> {
    Optional<User> findByUsername(String username);
}
