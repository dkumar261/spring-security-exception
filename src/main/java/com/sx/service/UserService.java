package com.sx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sx.dao.UserDao;
import com.sx.domain.User;
import com.sx.model.UserModel;
import com.sx.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<UserModel> getUsers() {

		return userDao.getUsers();
	}

	public UserModel getUserIdName(String name) {
		UserModel user = userDao.getUserIdName(name);
		return user;
	}

	public UserModel createUser(UserModel userModel) {
		String encode = passwordEncoder.encode(userModel.getPassword());
		User user = User.builder().name(userModel.getName()).password(encode).build();
		User savedUser = userRepository.save(user);

		UserModel returedUserModel = UserModel.builder().id(savedUser.getId()).name(savedUser.getName()).build();
		return returedUserModel;
	}

	public UserModel login(UserModel userModel) {

		User user = userRepository.getUserByName(userModel.getName());
		boolean isPasswordMatched = passwordEncoder.matches(userModel.getPassword(), user.getPassword());
		if (isPasswordMatched) {
			UserModel returedUserModel = UserModel.builder().id(user.getId()).name(user.getName()).build();
			return returedUserModel;
		}
		throw new BadCredentialsException("Invalid Password.");
	}
}
