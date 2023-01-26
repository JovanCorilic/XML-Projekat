package com.xml.zig.zigbackapp.model;

import java.util.Arrays;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@XmlRootElement(name = "user")
public class RegisterUser implements UserDetails  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private String role;
	

	public RegisterUser() {

	}

	public RegisterUser(String username, String password, String role) {

		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RegisterUser [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
