package com.springse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springse.dao.UserDao;
import com.springse.model.User;

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
