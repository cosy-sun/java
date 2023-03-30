package com.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "myAuditorAware")
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringdatajpaApplication.class, args);
		
		
	}
}
