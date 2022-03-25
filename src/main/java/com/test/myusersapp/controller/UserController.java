package com.test.myusersapp.controller;

import com.test.myusersapp.dto.user_creation_request.CreateUserRequest;
import com.test.myusersapp.dto.UserCreatedResponse;
import com.test.myusersapp.error.EmailRepeatedException;
import com.test.myusersapp.error.ErrorFormat;
import com.test.myusersapp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

    @Autowired
    IUserService IUserService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>("welcome", headers, HttpStatus.OK);
    }

    @PostMapping(path = "/user")
    public ResponseEntity<UserCreatedResponse> saveUser(@Valid @RequestBody CreateUserRequest createUserRequest) throws EmailRepeatedException {

        HttpHeaders headers = new HttpHeaders();
        UserCreatedResponse userCreatedResponse = IUserService.saveNewUser(createUserRequest);
        return new ResponseEntity<>(userCreatedResponse, headers, HttpStatus.OK);
    }

}
