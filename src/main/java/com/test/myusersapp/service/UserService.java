package com.test.myusersapp.service;

import com.test.myusersapp.dto.user_creation_request.CreatePhoneRequest;
import com.test.myusersapp.dto.user_creation_request.CreateUserRequest;
import com.test.myusersapp.dto.UserCreatedResponse;
import com.test.myusersapp.entities.Phone;
import com.test.myusersapp.entities.User;
import com.test.myusersapp.error.EmailRepeatedException;
import com.test.myusersapp.repository.PhoneRepository;
import com.test.myusersapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhoneRepository phoneRepository;

    public UserCreatedResponse saveNewUser(CreateUserRequest createUserRequest) throws EmailRepeatedException {

        User user = new User(createUserRequest);

        if (userRepository.findByEmail(user.getEmail()).isPresent())
            throw new EmailRepeatedException("Email repeated");


        user = userRepository.save(user);

        List<Phone> phones = new ArrayList<>();

        for (CreatePhoneRequest createPhoneRequest :
                createUserRequest.getPhones()) {
            Phone phone = new Phone(user, createPhoneRequest);
            phone = phoneRepository.save(phone);
            phones.add(phone);
        }

        return new UserCreatedResponse(user);
    }
}
