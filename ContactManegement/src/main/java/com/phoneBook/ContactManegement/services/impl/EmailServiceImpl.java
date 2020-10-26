package com.phoneBook.ContactManegement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.phoneBook.ContactManegement.entities.ContactsEntity;
import com.phoneBook.ContactManegement.entities.EmailsEntity;
import com.phoneBook.ContactManegement.reposotories.EmailRepository;
import com.phoneBook.ContactManegement.service.EmailService;
import com.phoneBook.ContactManegement.utils.ErrorConstants;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private EmailRepository emailRepo;

	@Override
	public EmailsEntity save(EmailsEntity email, Long id) {
		Assert.notNull(email, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		ContactsEntity user = new ContactsEntity();
		user.setId(id);
		email.setEmailContact(user);
		return emailRepo.save(email);
	}
}
