package com.test.myusersapp.dto.user_creation_request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = "Name is mandatory")
    String name;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Not a valid email")
    String email;
    @NotBlank(message = "password is mandatory")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,10}$", message = "not valid, at 8 to 10 characters, at least one letter and one number")
    String password;
    @Valid
    @NotNull(message = "A phone at least is mandatory")
    List<CreatePhoneRequest> phones;
}