package com.phoneBook.ContactManegement.services.impl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.phoneBook.ContactManegement.entities.ContactsEntity;
import com.phoneBook.ContactManegement.entities.EmailsEntity;
import com.phoneBook.ContactManegement.entities.UserEntity;
import com.phoneBook.ContactManegement.entities.phoneNumbersEntity;
import com.phoneBook.ContactManegement.reposotories.ContactsRepository;
import com.phoneBook.ContactManegement.service.contactService;
import com.phoneBook.ContactManegement.utils.ErrorConstants;

@Service
public class ContactServiceImpl implements contactService {

	private ContactsRepository contactRepo;

	public ContactServiceImpl(ContactsRepository contactRepo) {
		super();
		this.contactRepo = contactRepo;
	}

	@Override
	public List<ContactsEntity> findAll() {
		return contactRepo.findAll();

	}

	@Override
	public ContactsEntity save(ContactsEntity contact, Long id) {
		Assert.notNull(contact, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		UserEntity user = new UserEntity();
		user.setId(id);
		contact.setUser(user);
		return contactRepo.save(contact);
	}

	@Override
	public ContactsEntity updateContact(ContactsEntity contact, Long id) {
		Assert.notNull(id, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		Assert.notNull(contact, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);

		Optional<ContactsEntity> optionalContact = contactRepo.findById(id);

		if (!optionalContact.isPresent()) {
			throw new RuntimeErrorException(null, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		}

		ContactsEntity contactToUpdate = optionalContact.get();
		// better to use StructMapper to use the merge

		if (contact.getAddress() != null) {
			contactToUpdate.setAddress(contact.getAddress());
		}

		if (contact.getEmails() != null) {
			for (EmailsEntity email : contact.getEmails()) {
				boolean isPresent = false;
				for (EmailsEntity currentemail : contactToUpdate.getEmails()) {
					if (currentemail.getId() != null && currentemail.getId().equals(email.getId())) {
						currentemail.setEmail(email.getEmail());
						isPresent = true;
						break;
					}
				}
				if (!isPresent) {
					throw new RuntimeErrorException(null, "invalid email id");
				}
			}

		}
		if (contact.getEmergencyNumber() != null) {
			contactToUpdate.setEmergencyNumber(contact.getEmergencyNumber());

		}
		if (contact.getName() != null) {
			contactToUpdate.setName(contact.getName());
		}
		if (contact.getPhoneNumbers() != null) {
			for (phoneNumbersEntity phone : contact.getPhoneNumbers()) {
				boolean isPresent = false;
				for (phoneNumbersEntity currentphone : contactToUpdate.getPhoneNumbers()) {
					if (currentphone.getId() != null && currentphone.getId().equals(phone.getId())) {
						currentphone.setPhoneNumber(phone.getPhoneNumber());
						isPresent = true;
						break;
					}
				}
				if (!isPresent) {
					throw new RuntimeErrorException(null, "invalid phone id");
				}
			}

		}
		System.out.print(contactToUpdate);

		ContactsEntity update = contactRepo.save(contactToUpdate);
		return update;

	}

	@Override
	public void deleteById(Long id) {
		Assert.notNull(id, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		contactRepo.deleteById(id);
	}

	@Override
	public void deleteAll() {

		contactRepo.deleteAll();
	}

	@Override
	public List<ContactsEntity> search(String searchText) {
		Assert.hasText(searchText, ErrorConstants.MSG_ERROR_EMPTY_SEARCH_TEXT);
		List<ContactsEntity> contactList = contactRepo.findByName(searchText);
		return contactList;
	}

}
