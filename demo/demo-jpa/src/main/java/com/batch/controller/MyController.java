package com.batch.controller;

import com.batch.repository.RepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.batch.entity.User;

@Controller
@RequestMapping("/demo")
public class MyController {


	@Autowired
	private RepositoryTest repository;

	@GetMapping(path = "/add")
	public void addNewUser(@RequestParam String name, @RequestParam String email) {
		User  user = new User();
		user.setEamli(email);
		user.setName(name);
		repository.save(user);
	}

	@GetMapping("select")
	public void select() {
		User user = repository.findByName2("szh");
		System.out.println(user.getEamli());
	}

}
