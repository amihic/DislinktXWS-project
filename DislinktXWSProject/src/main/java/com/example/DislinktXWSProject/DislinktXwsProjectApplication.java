package com.example.DislinktXWSProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//OVDEaa
public class DislinktXwsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DislinktXwsProjectApplication.class, args);
	}

}
