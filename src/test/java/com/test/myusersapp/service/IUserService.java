package com.test.myusersapp.service;

import com.test.myusersapp.dto.UserCreatedResponse;
import com.test.myusersapp.entities.User;

public interface IUserService {
    public UserCreatedResponse saveNewUser(User user);
}
