package com.test.myusersapp.controller;

import com.test.myusersapp.dto.UserCreatedResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping
    public ResponseEntity<UserCreatedResponse> saveUser(){

    }
}
