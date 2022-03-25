package com.test.myusersapp.repository;

import com.test.myusersapp.entities.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, String> {
}
