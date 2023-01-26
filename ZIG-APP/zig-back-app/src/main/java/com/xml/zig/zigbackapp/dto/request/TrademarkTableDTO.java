package com.xml.zig.zigbackapp.dto.request;

public class TrademarkTableDTO {
	
	private String documentid;
	
	private String documenttype;

	private String status;
	
	
	public TrademarkTableDTO() {
	}

	public TrademarkTableDTO(String documentid, String documenttype) {
		this.documentid = documentid;
		this.documenttype = documenttype;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDocumentid() {
		return documentid;
	}

	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}

	public String getDocumenttype() {
		return documenttype;
	}

	public void setDocumenttype(String documenttype) {
		this.documenttype = documenttype;
	}
	
	
	
	
}
