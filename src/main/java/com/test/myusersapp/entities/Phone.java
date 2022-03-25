package com.test.myusersapp.entities;

import com.test.myusersapp.dto.user_creation_request.CreatePhoneRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue
    Long id;

    Integer number;

    Integer cityCode;

    Integer countryCode;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Phone(User user, CreatePhoneRequest createPhoneRequest){
        this.setNumber(createPhoneRequest.getNumber());
        this.setCityCode(createPhoneRequest.getCitycode());
        this.setCountryCode(createPhoneRequest.getCountrycode());
        this.setUser(user);
    }
}
