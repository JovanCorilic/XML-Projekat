package com.xml.zig.zigbackapp.dto.request.trademark_save_dto;

import com.xml.zig.zigbackapp.model.Contact;

public class SubjectInfo {
	
	private Subject subject;
	
	private Address address;
	
	private Contact contact;
	

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "SubjectInfo [subject=" + subject + ", address=" + address + ", contact=" + contact + "]";
	}

	
	
	
}
