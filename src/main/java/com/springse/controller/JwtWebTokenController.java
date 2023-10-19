package com.springse.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springse.model.JwtResponse;

@RestController
public class JwtWebTokenController {

	@PostMapping("token")
	public JwtResponse getToken(@RequestBody JwtRequest jwtRequest) {
		return new JwtResponse();
	}
}
