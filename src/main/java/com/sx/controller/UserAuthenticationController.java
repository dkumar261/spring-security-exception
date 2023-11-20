package com.sx.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sx.model.JwtResponse;
import com.sx.model.UserModel;
import com.sx.service.UserService;
import com.sx.util.ApplicationConstants;
import com.sx.util.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ApplicationConstants.API_URL_OAUTH)
public class UserAuthenticationController {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	public List<UserModel> users() {
		return userService.getUsers();
	}

	@PostMapping(ApplicationConstants.API_URL_TOKEN)
	public JwtResponse getUser(@RequestBody UserModel userModel) {

		log.info("User :" + userModel.getName() + " has login at " + new Date());
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userModel.getName(), userModel.getPassword()));

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Invalid User/Password:");
		}
		String generateToken = jwtTokenUtil.generateToken(userModel.getName());
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setToken(generateToken);
		return jwtResponse;
	}

	@PostMapping("/create")
	public UserModel addUser(@RequestBody UserModel userModel) {
		return userService.createUser(userModel);

	}
}
