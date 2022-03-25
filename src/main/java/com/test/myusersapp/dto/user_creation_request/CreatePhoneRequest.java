package com.test.myusersapp.dto.user_creation_request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
public class CreatePhoneRequest {

    @NotNull(message = "number is mandatory")
    @Positive(message = "must be a positive number")
    Integer number;
    @NotNull(message = "citycode is mandatory")
    @Positive(message = "must be a positive number")
    Integer citycode;
    @NotNull(message = "countrycode is mandatory")
    @Positive(message = "must be a positive number")
    Integer countrycode;

}
