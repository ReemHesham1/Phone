package com.phoneBook.ContactManegement.service;

import com.phoneBook.ContactManegement.entities.EmailsEntity;

public interface EmailService {

	EmailsEntity save(EmailsEntity email, Long id);

}
