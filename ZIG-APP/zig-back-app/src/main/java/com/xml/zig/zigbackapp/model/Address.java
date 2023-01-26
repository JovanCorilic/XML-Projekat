package com.xml.zig.zigbackapp.model;

public class Address {

	private String street_name;
	
	private String street_number;
	
	private String zip_code;
	
	private String city;
	
	private String country;

	
	
	public Address() {
	}

	public Address(String street_name, String street_number, String zip_code, String city, String country) {
		this.street_name = street_name;
		this.street_number = street_number;
		this.zip_code = zip_code;
		this.city = city;
		this.country = country;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [street_name=" + street_name + ", street_number=" + street_number + ", zip_code=" + zip_code
				+ ", city=" + city + ", country=" + country + "]";
	}
	
	
}
