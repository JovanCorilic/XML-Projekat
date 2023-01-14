package com.xml.users.usersapp.usersbackapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.users.usersapp.usersbackapp.dto.RegisterUserDTO;
import com.xml.users.usersapp.usersbackapp.model.RegisterUser;
import com.xml.users.usersapp.usersbackapp.service.UserService;

@RestController
@RequestMapping(value = "register",
	consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }

)
public class RegisterUserController {

	@Autowired
	private UserService us;

	@PostMapping
	public ResponseEntity<Boolean> registerUser(@RequestBody RegisterUserDTO rudto) {

		System.out.println(rudto);
		
		Boolean answer = us.saveUser(rudto);
		
		return new ResponseEntity<Boolean>(answer, HttpStatus.OK);

	}

	@GetMapping("/user/{username}")
	public ResponseEntity<RegisterUser> loginUser(@PathVariable("username") String username) {
		
		System.out.println("STIGAO SA URENAMEOM: " + username);
		
		RegisterUser answer = us.loadUser(username);

		return new ResponseEntity<RegisterUser>(answer, HttpStatus.OK);

	}

}
