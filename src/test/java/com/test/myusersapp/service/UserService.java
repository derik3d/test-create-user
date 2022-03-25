package com.test.myusersapp.service;

import com.test.myusersapp.dto.UserCreatedResponse;
import com.test.myusersapp.entities.User;
import com.test.myusersapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    public UserCreatedResponse saveNewUser(User user) {

        user = userRepository.save(user);
        UserCreatedResponse userCreaatedREsponse = new UserCreatedResponse(user);
        return userCreaatedREsponse;
    }
}
