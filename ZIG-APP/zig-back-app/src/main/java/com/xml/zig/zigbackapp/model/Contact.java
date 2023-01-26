package com.xml.zig.zigbackapp.model;

public class Contact {
	
	private String phone;
	
	private String faks;
	
	private String mail;

	
	public Contact() {
		
	}
	
	public Contact(String phone, String faks, String mail) {
		this.phone = phone;
		this.faks = faks;
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFaks() {
		return faks;
	}

	public void setFaks(String faks) {
		this.faks = faks;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Contact [phone=" + phone + ", faks=" + faks + ", mail=" + mail + "]";
	}
	
	
	
}
