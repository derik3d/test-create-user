package com.test.myusersapp.entities;

import com.test.myusersapp.dto.user_creation_request.CreateUserRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    String userUUId;

    @Column
    String name;
    @Column
    String email;
    @Column
    String password;

    @OneToMany(mappedBy = "user")
    List<Phone> phones;

    @Column
    LocalDateTime created;
    @Column
    LocalDateTime modified;
    @Column
    LocalDateTime lastLogIn;

    @Column
    String token;
    @Column
    Boolean isActive;

    public User(CreateUserRequest createUserRequest) {
        this.setUserUUId(UUID.randomUUID().toString());

        this.setName(createUserRequest.getName());
        this.setEmail(createUserRequest.getEmail());
        this.setPassword(createUserRequest.getPassword());

        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
        this.setLastLogIn(LocalDateTime.now());

        this.setToken(this.getUserUUId());

        this.setIsActive(true);
    }

}
