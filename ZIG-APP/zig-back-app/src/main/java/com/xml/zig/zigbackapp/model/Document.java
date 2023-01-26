package com.xml.zig.zigbackapp.model;

public class Document {

	private String document;
	
	public Document() {
	}
	
	public Document(String document) {
		this.document = document;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "Document [document=" + document + "]";
	}
	
	
	
}
