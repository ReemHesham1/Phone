package com.phoneBook.ContactManegement.service;

import java.util.List;

import com.phoneBook.ContactManegement.entities.ContactsEntity;

public interface contactService {

	List<ContactsEntity> findAll();

	ContactsEntity save(ContactsEntity contact, Long id);

	ContactsEntity updateContact(ContactsEntity contact, Long id);

	void deleteById(Long id);

	void deleteAll();

	List<ContactsEntity> search(String searchText);
}
