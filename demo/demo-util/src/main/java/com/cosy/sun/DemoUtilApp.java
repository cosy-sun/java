package com.cosy.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoUtilApp {

	public static void main(String[] args) {
		SpringApplication.run(DemoUtilApp.class, args);
	}

	@PostMapping("/k8s")
	public void DemoUtilController() {
		System.out.println("调用k8s");
	}
	
}
