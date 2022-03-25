package com.test.myusersapp.dto;

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
    //TODO name must be changed on JSON
    LocalDateTime lastLogIn;
    String token;
    //TODO name must be changed on JSON
    String isActive;
}
