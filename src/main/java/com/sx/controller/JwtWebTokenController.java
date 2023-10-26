package com.sx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sx.model.JwtRequest;
import com.sx.model.JwtResponse;
import com.sx.service.UserServiceToken;
import com.sx.util.JwtTokenUtil;

@RestController
public class JwtWebTokenController {

	@Autowired
	private UserServiceToken userServiceToken;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping("token")
	public JwtResponse getToken(@RequestBody JwtRequest jwtRequest) {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getName(), jwtRequest.getPassword()));

		} catch (Exception e) {
			System.out.println("Invalid User/Password:");
		}
		UserDetails loadUserByUsername = userServiceToken.loadUserByUsername(jwtRequest.getName());
		String generateToken = jwtTokenUtil.generateToken(loadUserByUsername);
		JwtResponse jwtResponse = new JwtResponse();
		jwtResponse.setToken(generateToken);
		return jwtResponse;
	}
}
