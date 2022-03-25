package com.test.myusersapp.repository;

import com.test.myusersapp.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByEmail(String email);
}
