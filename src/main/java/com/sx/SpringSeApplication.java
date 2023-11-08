package com.sx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Dinesh Kumar
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringSeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSeApplication.class, args);
	}
}
