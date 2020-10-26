package com.phoneBook.ContactManegement.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.phoneBook.ContactManegement.Dtos.PhoneNumberDTO;

@RequestMapping(value = "/api/phoneNumber")
public interface PhoneNumberApi {

	/**
	 * create new phoneNumber related to the contact with the id passed on @param id
	 * the contactId should be come from token (if token authorization is used)
	 * 
	 * @return PhoneNumberDTO created
	 */

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	PhoneNumberDTO createNewphoneNumb(@RequestBody PhoneNumberDTO phoneNumberDto,
			@RequestParam(value = "id", defaultValue = "1", required = true) Long id);

}
