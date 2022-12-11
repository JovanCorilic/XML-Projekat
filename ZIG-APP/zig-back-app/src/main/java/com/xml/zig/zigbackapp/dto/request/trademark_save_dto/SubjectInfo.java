package com.xml.zig.zigbackapp.dto.request.trademark_save_dto;

public class SubjectInfo {
	
	private Subject subject;
	
	private Address address;
	

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

	@Override
	public String toString() {
		return "SubjectInfo [subject=" + subject + ", address=" + address + "]";
	}
	
	
}
