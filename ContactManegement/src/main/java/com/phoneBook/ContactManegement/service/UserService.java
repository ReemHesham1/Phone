package com.phoneBook.ContactManegement.service;

import com.phoneBook.ContactManegement.entities.UserEntity;

public interface UserService {

	UserEntity createAndSaveUser(UserEntity user);

	UserEntity login(String username, String password);
}
