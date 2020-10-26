package com.phoneBook.ContactManegement.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.phoneBook.ContactManegement.Dtos.ContactsDTO;
import com.phoneBook.ContactManegement.controllers.ContactsRestController;
import com.phoneBook.ContactManegement.entities.ContactsEntity;
import com.phoneBook.ContactManegement.service.contactService;

@RunWith(SpringRunner.class)
public class ContactControllerTest {

	@InjectMocks
	private ContactsRestController controller;

	@Mock
	private ModelMapper contactModelMapper;

	@Mock
	private contactService service;

	private final static Long USER_ID = 12L;
	private final static Long CONTACT_ID = 123L;
	private final static String CONTACT_NAME = "name";
	private final static String ADDRESS = "address";
	private final static String EMERGENCY_NUMBER = "12345678990";

	private ContactsDTO prepareContactDTO() {
		ContactsDTO contactDto = new ContactsDTO();
		contactDto.setAddress(ADDRESS);
		contactDto.setName(CONTACT_NAME);
		return contactDto;
	}

	private ContactsEntity prepareContact() {
		ContactsEntity entity = new ContactsEntity();
		entity.setAddress(ADDRESS);
		entity.setName(CONTACT_NAME);
		return entity;
	}

	@Test
	public void getDContactById_whenCalledShouldReturnField_Test() {
		assertNotNull(contactModelMapper);
		ContactsEntity contact = prepareContact();
		List<ContactsEntity> list = new ArrayList<ContactsEntity>();
		list.add(contact);
		Mockito.when(service.search(Mockito.anyString())).thenReturn(list);

		ContactsDTO contactdto = prepareContactDTO();

		Mockito.when(contactModelMapper.map(Mockito.any(), Mockito.any())).thenReturn(contactdto);

		ResponseEntity<List<ContactsDTO>> response = controller.searchContact(CONTACT_NAME);
		assertNotNull(response);
		assertEquals(200, response.getStatusCodeValue());

	}
}
