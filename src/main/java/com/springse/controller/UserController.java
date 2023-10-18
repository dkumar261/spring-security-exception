package com.springse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springse.model.User;
import com.springse.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public List<User> users() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{name}")
	public User getUser(@PathVariable("name") String name) {
		return userService.getUserIdName(name);
	}
}
