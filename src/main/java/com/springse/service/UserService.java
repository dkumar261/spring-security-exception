package com.springse.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springse.model.User;

@Service
public class UserService {

	public List<User> getUsers() {
		
		List<User>users = Arrays.asList(new User("Dinesh","New Delhi"),new User("Vishal","Pune"));
		return users;
	}

}
