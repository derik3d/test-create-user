package com.test.myusersapp.entities;

import com.test.myusersapp.dto.user_creation_request.CreatePhoneRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phone {
    int number;
    int cityCode;
    int countryCode;

    public Phone(CreatePhoneRequest createPhoneRequest){
        this.setNumber(createPhoneRequest.getNumber());
        this.setCityCode(createPhoneRequest.getCitycode());
        this.setCountryCode(createPhoneRequest.getCountrycode());
    }
}
