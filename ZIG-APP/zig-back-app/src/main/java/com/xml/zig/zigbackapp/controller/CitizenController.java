package com.xml.zig.zigbackapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "citizen",
	consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
	produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }

)
public class CitizenController {
	
	@GetMapping
	public ResponseEntity<String> registerUser() {

		return new ResponseEntity<String>("cit LOG suc", HttpStatus.OK);

	}
	
}
