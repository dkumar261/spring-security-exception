package com.sx.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sx.model.UserModel;

@Repository
public class UserDao {

	List<UserModel> users;
	{
		users = Arrays.asList(new UserModel(null, "Dinesh", "New Delhi"), new UserModel(null, "Vishal", "Pune"), new UserModel(null, "Alok", "Indore"),
				new UserModel(null, "Jack", "Mumbai"), new UserModel(null, "Mayank", "Noida"));
	}
	
	public List<UserModel> getUsers() {

		return users;
	}
	
	public UserModel getUserIdName(String name) {
		UserModel user2 = users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList()).get(0);
		return user2;
	}
}
