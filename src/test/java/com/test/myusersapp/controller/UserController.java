package com.test.myusersapp.controller;

import com.test.myusersapp.dto.UserCreatedResponse;
import com.test.myusersapp.entities.User;
import com.test.myusersapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    IUserService IUserService;

    @PostMapping
    public ResponseEntity<UserCreatedResponse> saveUser(@RequestBody User user) {

        IUserService.saveNewUser(user);

        UserCreatedResponse userCreaatedREsponse = new UserCreatedResponse(user);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(userCreaatedREsponse, headers, HttpStatus.OK);
    }
}
