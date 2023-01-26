package com.xml.zig.zigbackapp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "trademark")
public class Trademark {
	
	
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

	private String trademark_id;//UUID 
	
	private String qrCode;
	
	private List<Document> documents;
	
	public Trademark() {
	}

	public Trademark(SubjectInfo applicant, SubjectInfo proxy, SubjectInfo common_representative,
			TrademarkInfo trademark_info, NiceClassification nice_classification,
			String requested_right_of_priority_and_basis, Fee fee, Institution institution, String trademark_number,
			Long date,List<Document> documents) {
		this.applicant = applicant;
		this.proxy = proxy;
		this.common_representative = common_representative;
		this.trademark_info = trademark_info;
		this.nice_classification = nice_classification;
		this.requested_right_of_priority_and_basis = requested_right_of_priority_and_basis;
		this.fee = fee;
		this.institution = institution;
		this.trademark_number = trademark_number;
		this.date = date;
		this.documents= documents;
	}

	
	
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getTrademark_id() {
		return trademark_id;
	}

	public void setTrademark_id(String trademark_id) {
		this.trademark_id = trademark_id;
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
				+ ", trademark_number=" + trademark_number + ", date=" + date + ", trademark_id=" + trademark_id
				+ ", qrCode=" + qrCode + ", documents=" + documents + "]";
	}

	
	
}
