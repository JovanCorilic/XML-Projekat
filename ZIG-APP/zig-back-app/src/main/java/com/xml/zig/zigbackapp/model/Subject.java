package com.xml.zig.zigbackapp.model;

public class Subject {

	private String company;
	
	private User user;

	public Subject() {
	}

	public Subject(String company, User user) {
		this.company = company;
		this.user = user;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Subject [company=" + company + ", user=" + user + "]";
	}
	
	
	
}
