package com.reliable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.reliable.controller")
public class Application {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(Application.class, args);
	}

}