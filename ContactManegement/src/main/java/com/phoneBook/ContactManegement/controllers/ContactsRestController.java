package com.phoneBook.ContactManegement.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.ContactManegement.Dtos.ContactsDTO;
import com.phoneBook.ContactManegement.api.ContactsApi;
import com.phoneBook.ContactManegement.entities.ContactsEntity;
import com.phoneBook.ContactManegement.service.contactService;

@RestController
public class ContactsRestController implements ContactsApi {

	@Autowired
	private contactService contactservice;

	@Autowired
	private ModelMapper contactMapper;

	public ContactsRestController(contactService contactservice, ModelMapper contactMapper) {
		super();
		this.contactservice = contactservice;
		this.contactMapper = contactMapper;
	}

	@Override
	public List<ContactsDTO> findByAll() {
		List<ContactsEntity> contatList = contactservice.findAll();
		List<ContactsDTO> mapList = contatList.stream().map(contact -> contactMapper.map(contact, ContactsDTO.class))
				.collect(Collectors.toList());
		return mapList;
	}

	@Override
	public ContactsDTO createNewContact(ContactsDTO contactDto, Long id) {
		ContactsEntity contact = contactMapper.map(contactDto, ContactsEntity.class);
		ContactsEntity newContact = contactservice.save(contact, id);
		ContactsDTO createdContact = contactMapper.map(newContact, ContactsDTO.class);
		return createdContact;
	}

	@Override
	public ContactsDTO update(@PathVariable("id") Long id, ContactsDTO contactDTO) {
		ContactsEntity contact = contactMapper.map(contactDTO, ContactsEntity.class);
		ContactsEntity updatedContact = contactservice.updateContact(contact, id);
		ContactsDTO newData = contactMapper.map(updatedContact, ContactsDTO.class);
		return newData;
	}

	@Override
	public void deleteById(Long id) {
		contactservice.deleteById(id);

	}

	@Override
	public void delete() {
		contactservice.deleteAll();

	}

	@Override
	public ResponseEntity<List<ContactsDTO>> searchContact(String searchText) {
		List<ContactsEntity> contactList = contactservice.search(searchText);
		List<ContactsDTO> mapList = contactList.stream()
				.map(postSearch -> contactMapper.map(postSearch, ContactsDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(mapList, HttpStatus.OK);
	}

}
