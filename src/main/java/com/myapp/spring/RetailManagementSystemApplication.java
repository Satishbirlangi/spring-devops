package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.vz.spring.items" })
public class RetailManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailManagementSystemApplication.class, args);
	}

}
