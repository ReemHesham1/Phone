package com.phoneBook.ContactManegement.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.phoneBook.ContactManegement.Dtos.ContactsDTO;

@RequestMapping(value = "/api/contacts")
public interface ContactsApi {

	@GetMapping
	List<ContactsDTO> findByAll();

	/**
	 * create new contact related to the user with the id passed on @param id the
	 * userId should be come from token (if token authorization is used)
	 * 
	 * @return ContactDto created
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	ContactsDTO createNewContact(@RequestBody ContactsDTO contactDto,
			@RequestParam(value = "id", defaultValue = "1", required = true) Long id);

	/**
	 * update contact related to the user with the id passed on @param id the userId
	 * should be come from token (if token authorization is used)
	 * 
	 * @return ContactDto updated and add new phoneNumber etc..
	 */
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	ContactsDTO update(@PathVariable("id") Long id, @RequestBody ContactsDTO contactDTOs);

	/*
	 * delete contact related to the user with the id passed on @param id the userId
	 * should be come from token (if token authorization is used)
	 * 
	 */
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	void deleteById(@PathVariable("id") Long id);

	/**
	 * delete contact related to the user with the id passed on @param id the userId
	 * should be come from token (if token authorization is used)
	 * 
	 */
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	void delete();

	/**
	 * search contact by name
	 * 
	 * @param search text
	 * @return contacts
	 */
	@GetMapping("/filtered")
	public ResponseEntity<List<ContactsDTO>> searchContact(
			@RequestParam(name = "searchText", required = true) String searchText);
//			@RequestParam(value = "page", defaultValue = "1", required = false) Long page,
//			@RequestParam(value = "size", defaultValue = "100", required = false) Long size);

}
