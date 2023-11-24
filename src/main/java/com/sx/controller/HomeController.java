package com.sx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping(value = "/ws/v1/home")
	public String users() {
		return "This is Home !!";
	}
}
