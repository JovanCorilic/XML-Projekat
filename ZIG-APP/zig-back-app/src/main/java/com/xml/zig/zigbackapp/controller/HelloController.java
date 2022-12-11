package com.xml.zig.zigbackapp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.zig.zigbackapp.dto.Student;

@RestController
@RequestMapping(value="hello")
public class HelloController {

	@GetMapping("h1")
	public String getHello() {
		return "hello zig-back-app";
	}
	
	@PostMapping("xml")
	public String getXMLFake(@RequestBody String xmldoc) {
		return xmldoc;
	}
	
	
	@PostMapping(
			value = "xmlTrue",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
	        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
	)
	public String getXMLTrue(@RequestBody Student student) {
//		System.out.println("USO");
		return student.getFname() + " je dodat. Zivi u ulici " + student.getAddress().getStreet() + " " + student.getAddress().getNumber();
	}
	
	@PostMapping(
			value = "save",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
	        produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
	)
	public String saveStudetn(@RequestBody Student student) {
//		System.out.println("USO");
		return student.getFname() + " je dodat. Zivi u ulici " + student.getAddress().getStreet() + " " + student.getAddress().getNumber();
	}
}
