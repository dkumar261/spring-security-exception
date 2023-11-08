package com.sx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HomeController {

	@GetMapping(value = "/ws/v1/home")
	public String users() {

		log.info("Hello from Logback {}", "Hare krsna !! ............ from lombok");
		log.error("Hello from Logback {}", "Error !! ............from lombok");
		return "This is Home !!";
	}
}
