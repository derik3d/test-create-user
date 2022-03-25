package com.test.myusersapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phone {
    int number;
    int cityCode;
    int countryCode;
}
