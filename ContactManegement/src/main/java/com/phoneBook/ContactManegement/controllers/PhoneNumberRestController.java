package com.phoneBook.ContactManegement.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.ContactManegement.Dtos.PhoneNumberDTO;
import com.phoneBook.ContactManegement.api.PhoneNumberApi;
import com.phoneBook.ContactManegement.entities.phoneNumbersEntity;
import com.phoneBook.ContactManegement.service.PhoneNumberService;

@RestController
public class PhoneNumberRestController implements PhoneNumberApi {

	@Autowired
	private PhoneNumberService phoneService;

	@Autowired
	private ModelMapper phoneMapper;

	public PhoneNumberRestController(PhoneNumberService phoneService, ModelMapper phoneMapper) {
		super();
		this.phoneService = phoneService;
		this.phoneMapper = phoneMapper;
	}

	@Override
	public PhoneNumberDTO createNewphoneNumb(PhoneNumberDTO phoneNumberDto, Long id) {
		phoneNumbersEntity phone = phoneMapper.map(phoneNumberDto, phoneNumbersEntity.class);
		phoneNumbersEntity newphone = phoneService.save(phone, id);
		PhoneNumberDTO createdphone = phoneMapper.map(newphone, PhoneNumberDTO.class);
		return createdphone;
	}

}
