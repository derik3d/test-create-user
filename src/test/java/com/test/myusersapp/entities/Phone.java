package com.test.myusersapp.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phone {
    int number;
    //TODO must be all lowecase on json
    int cityCode;
    //TODO must be all lowercase on json
    int countryCode;
}
