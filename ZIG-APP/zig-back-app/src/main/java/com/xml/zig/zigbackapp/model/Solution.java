package com.xml.zig.zigbackapp.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "solution")
public class Solution {
	private String id;
	
	private long date;
	
	private String trademark_number;
	
	private String username;
	
	private String trademark_id;
	
	private String description;

	
	
	
	public Solution() {
	}

	
	
	
	public Solution(String id, long date, String trademark_number, String username,
			String trademark_id, String description) {
		this.id = id;
		this.date = date;
		this.trademark_number = trademark_number;
		this.username = username;
		this.trademark_id = trademark_id;
		this.description = description;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getTrademark_number() {
		return trademark_number;
	}

	public void setTrademark_number(String trademark_number) {
		this.trademark_number = trademark_number;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTrademark_id() {
		return trademark_id;
	}

	public void setTrademark_id(String trademark_id) {
		this.trademark_id = trademark_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Solution [id=" + id + ", date=" + date + ", trademark_number=" + trademark_number + ", username="
				+ username + ", trademark_id=" + trademark_id + ", description=" + description + "]";
	}

	
	
}
