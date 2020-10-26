package com.phoneBook.ContactManegement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.phoneBook.ContactManegement.entities.ContactsEntity;
import com.phoneBook.ContactManegement.entities.phoneNumbersEntity;
import com.phoneBook.ContactManegement.reposotories.PhoneNumberRepository;
import com.phoneBook.ContactManegement.service.PhoneNumberService;
import com.phoneBook.ContactManegement.utils.ErrorConstants;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService {

	@Autowired
	private PhoneNumberRepository phoneRepo;

	@Override
	public phoneNumbersEntity save(phoneNumbersEntity phone, Long id) {
		Assert.notNull(phone, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		ContactsEntity contact = new ContactsEntity();
		contact.setId(id);
		phone.setPhoneContacts(contact);
		return phoneRepo.save(phone);
	}

}
