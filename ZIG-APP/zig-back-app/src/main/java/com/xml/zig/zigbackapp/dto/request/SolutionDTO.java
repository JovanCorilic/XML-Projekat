package com.xml.zig.zigbackapp.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.xml.zig.zigbackapp.dto.request.trademark_save_dto.Institution;

@XmlRootElement(name = "solution")
public class SolutionDTO {

	private String username;

	private String trademark_id;

	private String description;
	
	private String status;
	
	private Institution institution;
	
	private String trademark_number;
	
	private Long date;
	
	public SolutionDTO() {
	}

	
	
	
	public SolutionDTO(String username, String trademark_id, String description, String status, Institution institution,
			String trademark_number, Long date) {
		super();
		this.username = username;
		this.trademark_id = trademark_id;
		this.description = description;
		this.status = status;
		this.institution = institution;
		this.trademark_number = trademark_number;
		this.date = date;
	}




	public String getTrademark_number() {
		return trademark_number;
	}




	public void setTrademark_number(String trademark_number) {
		this.trademark_number = trademark_number;
	}




	public Long getDate() {
		return date;
	}




	public void setDate(Long date) {
		this.date = date;
	}




	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

}
