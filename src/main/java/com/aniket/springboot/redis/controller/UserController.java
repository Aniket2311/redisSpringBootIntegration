package com.aniket.springboot.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aniket.springboot.redis.dao.UserDAO;
import com.aniket.springboot.redis.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserDAO userDao;

	@GetMapping("/add/{id}/name/{name}")
	public User addUser(@PathVariable("id") String id, @PathVariable("name") String name) {

		final String email = name + "@gmail.com";
		userDao.saveUser(new User(id, name, email));

		return userDao.getById(id);
	}

	@GetMapping("/update/{id}/name/{name}")
	public User updateUser(@PathVariable("id") String id, @PathVariable("name") String name) {

		final String email = name + "@gmail.com";
		userDao.updateUser(new User(id, name, email));

		return userDao.getById(id);
	}

	@GetMapping("/all")
	public Map<String, User> getAllUsers() {

		return userDao.getAllUsers();
	}

	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable("id") String id) {

		return userDao.getById(id);
	}
}
