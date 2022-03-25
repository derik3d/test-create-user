package com.test.myusersapp.dto.user_creation_request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreateUserRequest {
    String name;
    String email;
    String password;
    List<CreatePhoneRequest> phones;
}