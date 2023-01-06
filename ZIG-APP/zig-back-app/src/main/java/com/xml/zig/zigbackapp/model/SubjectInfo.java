package com.xml.zig.zigbackapp.model;

public class SubjectInfo {
	
	private Subject subject;
	
	private Address address;

	private Contact contact;
	
	public SubjectInfo() {
	}

	public SubjectInfo(Subject subject, Address address,Contact contact) {
		this.subject = subject;
		this.address = address;
		this.contact = contact;
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
