package com.xml.zig.zigbackapp.dto.request.authentication_request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class JwtAuthenticationRequest {
	
	private String username;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
}
