package com.xml.users.usersapp.usersbackapp.service;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xml.users.usersapp.usersbackapp.dto.RegisterUserDTO;
import com.xml.users.usersapp.usersbackapp.jaxb.JaxB;
import com.xml.users.usersapp.usersbackapp.model.RegisterUser;
import com.xml.users.usersapp.usersbackapp.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private JaxB jaxB;
	
	@Autowired
	private BCryptPasswordEncoder bcencoder;

	public Boolean saveUser(RegisterUserDTO rudto) {
		
		RegisterUser u = new RegisterUser();

		u.setUsername(rudto.getUsername());
		u.setPassword(bcencoder.encode(rudto.getPassword()));
		u.setRole(rudto.getRole());
		
		String user_text="";
		
		try {
			user_text = jaxB.marshall(RegisterUser.class, u);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		try {
			ur.saveUser(user_text, u.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public RegisterUser loadUser(String username) {
		String user_text = "";
		try {
			user_text = ur.loadUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RegisterUser ru = new RegisterUser();
		
		try {
			ru = jaxB.unmarshall(RegisterUser.class, user_text);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return ru;
	}

}
