package com.xml.zig.zigbackapp.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {
	
	@XmlElement(name = "first_name")
	private String first_name;
	
	@XmlElement(name = "last_name")
	private String lname;
	
	@XmlElement(name = "age")
	private Integer age;
	
	@XmlElement(name = "address")
	private Address address;

	
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFname() {
		return first_name;
	}

	public void setFname(String fname) {
		this.first_name = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	
	
}
