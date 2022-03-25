package com.test.myusersapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {
    String name;
    String email;
    String password;
    List<Phone> phones;
}
