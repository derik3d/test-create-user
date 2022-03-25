package com.test.myusersapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.myusersapp.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserCreatedResponse {
    String id;
    LocalDateTime created;
    LocalDateTime modified;
    @JsonProperty(value = "last_login")
    LocalDateTime lastLogIn;
    String token;
    @JsonProperty(value = "isactive")
    Boolean isActive;

    public UserCreatedResponse(User user){
        this.setId(user.getUserUUId());
        this.setCreated(user.getCreated());
        this.setModified(user.getModified());
        this.setLastLogIn(user.getLastLogIn());
        this.setToken(user.getToken());
        this.setIsActive(user.getIsActive());
    }
}
