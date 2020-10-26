package com.phoneBook.ContactManegement.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.ContactManegement.Dtos.EmailsDTO;
import com.phoneBook.ContactManegement.api.EmailApi;
import com.phoneBook.ContactManegement.entities.EmailsEntity;
import com.phoneBook.ContactManegement.service.EmailService;

@RestController
public class EmailRestController implements EmailApi {

	@Autowired
	private ModelMapper emailMapper;

	@Autowired
	private EmailService emailService;

	public EmailRestController(ModelMapper emailMapper, EmailService emailService) {
		super();
		this.emailMapper = emailMapper;
		this.emailService = emailService;
	}

	@Override
	public EmailsDTO createNewEmail(EmailsDTO emailDto, Long id) {
		EmailsEntity email = emailMapper.map(emailDto, EmailsEntity.class);
		EmailsEntity newEmail = emailService.save(email, id);
		EmailsDTO createEmail = emailMapper.map(newEmail, EmailsDTO.class);
		return createEmail;
	}

}
