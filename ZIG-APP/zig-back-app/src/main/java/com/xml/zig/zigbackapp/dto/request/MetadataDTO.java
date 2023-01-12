package com.xml.zig.zigbackapp.dto.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metadata")
public class MetadataDTO {

	private String role;
	
	private String usrname;

	private Boolean usernamenot;

	private String typa;

	private Boolean typenot;

	private Long datestart;
	
	private Long dateend;

	private Boolean datenot;

	private Boolean firstop;
	
	private Boolean secondop;
	
	public MetadataDTO() {
		super();
		
	}

	public MetadataDTO(String role, String usrname, Boolean usernamenot, String typa, Boolean typenot, Long datestart,
			Long dateend, Boolean datenot ,  Boolean firstop, Boolean secondop) {
		super();
		this.role = role;
		this.usrname = usrname;
		this.usernamenot = usernamenot;
		this.typa = typa;
		this.typenot = typenot;
		this.datestart = datestart;
		this.dateend = dateend;
		this.datenot = datenot;
		this.firstop = firstop;
		this.secondop = secondop;
	}
	
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getFirstop() {
		return firstop;
	}

	public void setFirstop(Boolean firstop) {
		this.firstop = firstop;
	}

	public Boolean getSecondop() {
		return secondop;
	}

	public void setSecondop(Boolean secondop) {
		this.secondop = secondop;
	}

	public String getUsrname() {
		return usrname;
	}

	public void setUsrname(String usrname) {
		this.usrname = usrname;
	}

	public Boolean getUsernamenot() {
		return usernamenot;
	}

	public void setUsernamenot(Boolean usernamenot) {
		this.usernamenot = usernamenot;
	}

	public String getTypa() {
		return typa;
	}

	public void setTypa(String typa) {
		this.typa = typa;
	}

	public Boolean getTypenot() {
		return typenot;
	}

	public void setTypenot(Boolean typenot) {
		this.typenot = typenot;
	}

	public Long getDatestart() {
		return datestart;
	}

	public void setDatestart(Long datestart) {
		this.datestart = datestart;
	}

	public Long getDateend() {
		return dateend;
	}

	public void setDateend(Long dateend) {
		this.dateend = dateend;
	}

	public Boolean getDatenot() {
		return datenot;
	}

	public void setDatenot(Boolean datenot) {
		this.datenot = datenot;
	}
	
	

}
