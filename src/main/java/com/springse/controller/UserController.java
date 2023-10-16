package com.springse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springse.model.User;
import com.springse.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/users")
	public List<User> users() {
		return userService.getUsers();
	}
}
