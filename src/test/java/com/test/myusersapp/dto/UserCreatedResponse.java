package com.test.myusersapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.myusersapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserCreatedResponse {
    String userId;
    LocalDateTime created;
    LocalDateTime modified;
    @JsonProperty(value = "last_login")
    LocalDateTime lastLogIn;
    String token;
    @JsonProperty(value = "isactive")
    String isActive;

    public UserCreatedResponse(User user){
        //TODO load user data on response
    }
}
