package com.xml.zig.zigbackapp.dto.request.trademark_save_dto;

public class Subject {

	private String company;
	
	private User user;


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
