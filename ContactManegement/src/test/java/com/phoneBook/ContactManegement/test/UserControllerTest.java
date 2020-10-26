package com.phoneBook.ContactManegement.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.phoneBook.ContactManegement.Dtos.UserDTO;
import com.phoneBook.ContactManegement.controllers.UserRestController;
import com.phoneBook.ContactManegement.entities.UserEntity;
import com.phoneBook.ContactManegement.service.UserService;

@RunWith(SpringRunner.class)
public class UserControllerTest {

	private final static String USER_NAME = "username";
	private final static String PASSWORD = "pass1234";
	private final static String WRONG_PASS = "1234";
	private final static Long ID = 1L;

	private BCryptPasswordEncoder encoder = mock(BCryptPasswordEncoder.class);

	@InjectMocks
	private UserRestController userController;

	@Mock
	private UserService service;

	@Mock
	private ModelMapper userModelMapper;

	private UserDTO prepareUserDTO() {
		UserDTO userDto = new UserDTO();
		userDto.setUsername(USER_NAME);
		userDto.setPassword(PASSWORD);
		return userDto;
	}

	private UserEntity prepareUser() {
		UserEntity user = new UserEntity();
		user.setUsername(USER_NAME);
		user.setPassword(PASSWORD);
		return user;
	}

	@Test
	public void create_User_Happy_Path() {
		UserDTO userDto = prepareUserDTO();
		UserEntity user = prepareUser();
		assertNotNull(userModelMapper);

		Mockito.when(userModelMapper.map(userDto, UserEntity.class)).thenReturn(user);
		Mockito.when(service.createAndSaveUser(Mockito.any())).thenReturn(user);
		Mockito.when(userModelMapper.map(user, UserDTO.class)).thenReturn(userDto);

		UserDTO response = userController.save(userDto);
		assertNotNull(response);
		assertEquals(USER_NAME, response.getUsername());

	}

}
