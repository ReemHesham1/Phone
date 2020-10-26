package com.phoneBook.ContactManegement.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.phoneBook.ContactManegement.Dtos.EmailsDTO;

@RequestMapping(value = "/api/Email")
public interface EmailApi {

	/**
	 * create new email related to the contact with the id passed on @param id the
	 * contactId should be come from token (if token authorization is used)
	 * 
	 * @return EmailDto created
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	EmailsDTO createNewEmail(@RequestBody EmailsDTO emailDto,
			@RequestParam(value = "id", defaultValue = "1", required = true) Long id);
}
