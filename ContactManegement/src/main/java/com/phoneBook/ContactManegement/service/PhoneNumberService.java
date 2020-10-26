package com.phoneBook.ContactManegement.service;

import com.phoneBook.ContactManegement.entities.phoneNumbersEntity;

public interface PhoneNumberService {

	phoneNumbersEntity save(phoneNumbersEntity phone, Long id);
}
