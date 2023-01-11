package com.xml.zig.zigbackapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xml.zig.zigbackapp.model.RegisterUser;
import com.xml.zig.zigbackapp.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
    private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		RegisterUser user = userRepository.findByUsername(username);
		System.out.println(user);
        if (user == null) {

            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {

            return user;
        }
	}

}
