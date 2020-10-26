package com.phoneBook.ContactManegement.services.impl;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.phoneBook.ContactManegement.entities.UserEntity;
import com.phoneBook.ContactManegement.reposotories.UserRepository;
import com.phoneBook.ContactManegement.service.UserService;
import com.phoneBook.ContactManegement.utils.ErrorConstants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional(readOnly = false)
	public UserEntity createAndSaveUser(UserEntity user) {
		Assert.notNull(user, ErrorConstants.MSG_ERROR_NO_PARAM_KEY);
		UserEntity username = userRepo.findByUsername(user.getUsername());
		if (username != null) {
			if (user.getUsername().equals(username.getUsername())) {
				throw new RuntimeErrorException(null, ErrorConstants.MSG_ERROR_USERNAME);
			}
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public UserEntity login(String username, String password) {
		boolean isPasswordMatch;
		UserEntity uservalidate = userRepo.findByUsername(username);
		if (uservalidate == null) {
			throw new RuntimeErrorException(null, ErrorConstants.MSG_ERROR_USERNAME_PASS);
		}
		if (isPasswordMatch = passwordEncoder.matches(password, uservalidate.getPassword()) == false) {
			throw new RuntimeErrorException(null, ErrorConstants.MSG_ERROR_PASS);
		}

		return uservalidate;
	}

}
