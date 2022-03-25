package com.test.myusersapp.entities;

import com.test.myusersapp.dto.user_creation_request.CreateUserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class User {

    String userUUId;

    String name;
    String email;
    String password;
    List<Phone> phones;

    LocalDateTime created;
    LocalDateTime modified;
    LocalDateTime lastLogIn;

    String token;
    Boolean isActive;

    public User(CreateUserRequest createUserRequest, List<Phone> phones) {
        this.setUserUUId(UUID.randomUUID().toString());

        this.setName(createUserRequest.getName());
        this.setEmail(createUserRequest.getEmail());
        this.setPassword(createUserRequest.getPassword());
        this.setPhones(phones);

        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
        this.setLastLogIn(LocalDateTime.now());

        this.setToken(this.getUserUUId());

        this.setIsActive(true);
    }

}
