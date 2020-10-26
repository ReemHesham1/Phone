package com.phoneBook.ContactManegement.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.phoneBook.ContactManegement.Dtos.ContactsDTO;
import com.phoneBook.ContactManegement.entities.ContactsEntity;
import com.phoneBook.ContactManegement.reposotories.ContactsRepository;
import com.phoneBook.ContactManegement.services.impl.ContactServiceImpl;

@RunWith(SpringRunner.class)
public class ContactServiceImplTest {

	private final static Long USER_ID = 12L;
	private final static Long CONTACT_ID = 123L;
	private final static String CONTACT_NAME = "name";
	private final static String ADDRESS = "address";
	private final static String EMERGENCY_NUMBER = "12345678990";

	@InjectMocks
	private ContactServiceImpl service;

	@Mock
	private ContactsRepository repo;

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

// test add contact 
	@Test
	public void addNewontact_whenReturnsContactEntity_Test() {
		ContactsEntity entity = prepareContact();
		when(repo.save(Mockito.any())).thenReturn(entity);
		ContactsEntity contact = service.save(entity, USER_ID);
		assertEquals(contact.getAddress(), entity.getAddress());
	}

	@Test(expected = IllegalArgumentException.class)
	public void addNewContact_whenReturnsNull_Test() {
		service.save(null, null);
	}
	// test delete contact by id

	@Test
	public void deleteContact_WhenExists_ShouldDelete() {
		ContactsEntity entity = prepareContact();
//		 doNothing().when(repo.deleteById(Mockito.any()));
		Mockito.doAnswer(invocation -> {
			Object arg0 = invocation.getArgument(0);
			assertEquals(CONTACT_ID, arg0);
			return null;
		}).when(repo).deleteById(CONTACT_ID);
		service.deleteById(CONTACT_ID);

	}

	@Test(expected = IllegalArgumentException.class)
	public void deletecontact_WhenId_IsNull_ThenReturnLogictException() {
		service.deleteById(null);
	}

	// test find contact by name

	@Test
	public void getContactByName_whenCalledThenShouldReturnDto_Test() {
		ContactsEntity entity = prepareContact();

	}

//	@Test(expected = LogicException.class)
//	public void getDGPByIdTest_whenEntityNotFoundThenShouldThrowEx_Test() {
//		when(dgpRepository.findById(Mockito.anyLong())).thenReturn(Optional.ofNullable(null));
//		service.getDGPById(1L);
//	}

	@Test(expected = IllegalArgumentException.class)
	public void getContactByIdTest_when_EmtyName_Test() {
		service.search(null);
	}
}
