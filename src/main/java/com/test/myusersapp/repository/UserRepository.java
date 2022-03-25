package com.test.myusersapp.repository;

import com.test.myusersapp.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
