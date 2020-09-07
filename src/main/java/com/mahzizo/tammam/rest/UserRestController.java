package com.mahzizo.tammam.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahzizo.tammam.model.user.User;
import com.mahzizo.tammam.service.user.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	private UserService userService;

	// Get user by email and password
	@GetMapping("/getuser/{email}/{password}")
	public ResponseEntity<User> getBook(@PathVariable("email") String email,
			@PathVariable("password") String password) {
		User user = userService.getUser(email, password);
		return ResponseEntity.ok().body(user);
	}

	// Save the book
	@PostMapping("/adduser")
	public ResponseEntity<?> saveBook(@RequestBody User user) {
		userService.saveOrUpdateUser(user);
		return ResponseEntity.ok().body(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
