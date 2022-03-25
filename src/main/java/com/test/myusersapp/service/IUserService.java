package com.test.myusersapp.service;

import com.test.myusersapp.dto.user_creation_request.CreateUserRequest;
import com.test.myusersapp.dto.UserCreatedResponse;

public interface IUserService {
    public UserCreatedResponse saveNewUser(CreateUserRequest user);
}
