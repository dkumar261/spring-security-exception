package com.sx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sx.model.UserModel;
import com.sx.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	public List<UserModel> users() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{name}")
	public UserModel getUser(@PathVariable("name") String name) {
		return userService.getUserIdName(name);
	}

	@PostMapping("/create")
	public UserModel addUser(@RequestBody UserModel userModel) {
		return userService.createUser(userModel);
		
	}
}

