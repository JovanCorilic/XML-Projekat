package com.xml.zig.zigbackapp.repository;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.xml.zig.zigbackapp.model.RegisterUser;

@Component
public class UserRepository {

	public RegisterUser findByUsername(String username) {
//		System.out.println("PRE " + username);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		
		HttpEntity<String> request = new HttpEntity<String>("body",headers);
		
		RestTemplate restTemplate = new RestTemplate();
		
		String fooResourceUrl
		  = "http://localhost:9090/register/user/"+ username;
		
//		System.out.println("fooResourceUrl " + fooResourceUrl);
		
		ResponseEntity<RegisterUser> response = restTemplate.exchange(fooResourceUrl,HttpMethod.GET,request ,RegisterUser.class);
//		System.out.println(response.getBody());
		return response.getBody();
//		ResponseEntity<RegisterUser> response
//		  = restTemplate.getForEntity(fooResourceUrl , RegisterUser.class);
//		System.out.println("PRE KRAJA");
//		System.out.println(response.getBody());
//		return response.getBody();
	}

}
