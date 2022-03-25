package com.test.myusersapp.dto.user_creation_request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatePhoneRequest {
    int number;
    int citycode;
    int countrycode;
}
