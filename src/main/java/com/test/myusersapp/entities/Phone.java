package com.test.myusersapp.entities;

import com.test.myusersapp.dto.user_creation_request.CreatePhoneRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Phone {

    @Id
    Long id;

    Integer number;
    Integer cityCode;
    Integer countryCode;

    public Phone(CreatePhoneRequest createPhoneRequest){
        this.setNumber(createPhoneRequest.getNumber());
        this.setCityCode(createPhoneRequest.getCitycode());
        this.setCountryCode(createPhoneRequest.getCountrycode());
    }
}
