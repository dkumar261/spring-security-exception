package com.springse.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.springse.model.User;

@Repository
public class UserDao {

	List<User> users;
	{
		users = Arrays.asList(new User("Dinesh", "New Delhi"), new User("Vishal", "Pune"), new User("Alok", "Indore"),
				new User("Jack", "Mumbai"), new User("Mayank", "Noida"));
	}
	
	public List<User> getUsers() {

		return users;
	}
	
	public User getUserIdName(String name) {
		User user2 = users.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList()).get(0);
		return user2;
	}
}
