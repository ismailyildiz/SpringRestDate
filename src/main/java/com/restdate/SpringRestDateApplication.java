package com.restdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com", "com.restdate.service", "com.restdate.model",
		"com.restdate.controller", "com.restdate" })
public class SpringRestDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDateApplication.class, args);
	}
}
