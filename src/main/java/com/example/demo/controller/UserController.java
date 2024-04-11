package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		String token = userService.createUser(user);
		return ResponseEntity.ok(token);
	}


	@GetMapping("/filter")
	public ResponseEntity<List<User>> filterUsersByCountry(@RequestParam String country) {
		// Implement filtering logic
//		List<User> users = userRepository.findByAddressCountry(country);
//		return ResponseEntity.ok(users);
		return null;
	}
}
