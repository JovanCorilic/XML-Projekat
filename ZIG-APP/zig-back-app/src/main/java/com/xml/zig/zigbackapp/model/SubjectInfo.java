package com.xml.zig.zigbackapp.model;

public class SubjectInfo {
	
	private Subject subject;
	
	private Address address;

	
	
	public SubjectInfo() {
	}

	public SubjectInfo(Subject subject, Address address) {
		this.subject = subject;
		this.address = address;
	}

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
