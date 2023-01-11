package com.xml.zig.zigbackapp.dto.request.trademark_save_dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.xml.zig.zigbackapp.model.Document;
import com.xml.zig.zigbackapp.model.NiceClassification;

@XmlRootElement(name = "trademark")
public class TrademarkSaveDTO {
	
	
	private SubjectInfo applicant;
	
	private SubjectInfo proxy;
	
	private SubjectInfo common_representative;
	
	private TrademarkInfo trademark_info;
	
	private NiceClassification nice_classification;
	
	private String requested_right_of_priority_and_basis;
	
	private Fee fee;
	
	private Institution institution;
	
	private String trademark_number;
	
	private Long date;//date in milliseconds

	private ArrayList<Document> documents;

	
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}

	public SubjectInfo getApplicant() {
		return applicant;
	}

	public void setApplicant(SubjectInfo applicant) {
		this.applicant = applicant;
	}

	public SubjectInfo getProxy() {
		return proxy;
	}

	public void setProxy(SubjectInfo proxy) {
		this.proxy = proxy;
	}

	public SubjectInfo getCommon_representative() {
		return common_representative;
	}

	public void setCommon_representative(SubjectInfo common_representative) {
		this.common_representative = common_representative;
	}

	public TrademarkInfo getTrademark_info() {
		return trademark_info;
	}

	public void setTrademark_info(TrademarkInfo trademark_info) {
		this.trademark_info = trademark_info;
	}

	public NiceClassification getNice_classification() {
		return nice_classification;
	}

	public void setNice_classification(NiceClassification nice_classification) {
		this.nice_classification = nice_classification;
	}

	public String getRequested_right_of_priority_and_basis() {
		return requested_right_of_priority_and_basis;
	}

	public void setRequested_right_of_priority_and_basis(String requested_right_of_priority_and_basis) {
		this.requested_right_of_priority_and_basis = requested_right_of_priority_and_basis;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
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

	@Override
	public String toString() {
		return "Trademark [applicant=" + applicant + ", proxy=" + proxy + ", common_representative="
				+ common_representative + ", trademark_info=" + trademark_info + ", nice_classification="
				+ nice_classification + ", requested_right_of_priority_and_basis="
				+ requested_right_of_priority_and_basis + ", fee=" + fee + ", institution=" + institution
				+ ", trademark_number=" + trademark_number + ", date=" + date + "]";
	}
	
	
	
}
