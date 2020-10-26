package com.phoneBook.ContactManegement.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.phoneBook.ContactManegement.Dtos.UserDTO;
import com.phoneBook.ContactManegement.api.UserApi;
import com.phoneBook.ContactManegement.entities.UserEntity;
import com.phoneBook.ContactManegement.service.UserService;

@RestController
public class UserRestController implements UserApi {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper userMapper;

	public UserRestController(UserService userService, ModelMapper userMapper) {
		super();
		this.userService = userService;
		this.userMapper = userMapper;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = userMapper.map(userDTO, UserEntity.class);
		UserEntity savedUser = userService.createAndSaveUser(userEntity);
		UserDTO newUser = userMapper.map(savedUser, UserDTO.class);
		return newUser;

	}

	@Override
	public void logIn(String username, String password) {

		UserEntity existedUser = userService.login(username, password);

	}

}
