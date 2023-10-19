package com.sx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sx.dao.UserDao;
import com.sx.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getUsers() {

		return userDao.getUsers();
	}

	public User getUserIdName(String name) {
		User user = userDao.getUserIdName(name);
		return user;
	}
}
