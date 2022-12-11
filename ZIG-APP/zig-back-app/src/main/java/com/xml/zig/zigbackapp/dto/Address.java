package com.xml.zig.zigbackapp.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {

	
	private String street;
	
	private String number;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
}
