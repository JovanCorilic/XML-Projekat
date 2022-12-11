package com.xml.zig.zigbackapp.model;

public class Institution {

	private String trademark_sample; //FILE PATH
	
	private String list_of_goods_and_services; //FILE PATH
	
	private String power_of_attorney; //FILE PATH
	
	private boolean general_power_of_attorney_previously_submitted;
	
	private boolean power_of_attorney_will_be_delivered_later;
	
	private String general_act; //FILE PATH
	
	private String proof_of_priority; //FILE PATH
	
	private String proof_of_fee_payment; //FILE PATH

	
	
	
	public Institution() {
	}

	public Institution(String trademark_sample, String list_of_goods_and_services, String power_of_attorney,
			boolean general_power_of_attorney_previously_submitted, boolean power_of_attorney_will_be_delivered_later,
			String general_act, String proof_of_priority, String proof_of_fee_payment) {
	
		this.trademark_sample = trademark_sample;
		this.list_of_goods_and_services = list_of_goods_and_services;
		this.power_of_attorney = power_of_attorney;
		this.general_power_of_attorney_previously_submitted = general_power_of_attorney_previously_submitted;
		this.power_of_attorney_will_be_delivered_later = power_of_attorney_will_be_delivered_later;
		this.general_act = general_act;
		this.proof_of_priority = proof_of_priority;
		this.proof_of_fee_payment = proof_of_fee_payment;
		
	}

	public String getTrademark_sample() {
		return trademark_sample;
	}

	public void setTrademark_sample(String trademark_sample) {
		this.trademark_sample = trademark_sample;
	}

	public String getList_of_goods_and_services() {
		return list_of_goods_and_services;
	}

	public void setList_of_goods_and_services(String list_of_goods_and_services) {
		this.list_of_goods_and_services = list_of_goods_and_services;
	}

	public String getPower_of_attorney() {
		return power_of_attorney;
	}

	public void setPower_of_attorney(String power_of_attorney) {
		this.power_of_attorney = power_of_attorney;
	}

	public boolean isGeneral_power_of_attorney_previously_submitted() {
		return general_power_of_attorney_previously_submitted;
	}

	public void setGeneral_power_of_attorney_previously_submitted(boolean general_power_of_attorney_previously_submitted) {
		this.general_power_of_attorney_previously_submitted = general_power_of_attorney_previously_submitted;
	}

	public boolean isPower_of_attorney_will_be_delivered_later() {
		return power_of_attorney_will_be_delivered_later;
	}

	public void setPower_of_attorney_will_be_delivered_later(boolean power_of_attorney_will_be_delivered_later) {
		this.power_of_attorney_will_be_delivered_later = power_of_attorney_will_be_delivered_later;
	}

	public String getGeneral_act() {
		return general_act;
	}

	public void setGeneral_act(String general_act) {
		this.general_act = general_act;
	}

	public String getProof_of_priority() {
		return proof_of_priority;
	}

	public void setProof_of_priority(String proof_of_priority) {
		this.proof_of_priority = proof_of_priority;
	}

	public String getProof_of_fee_payment() {
		return proof_of_fee_payment;
	}

	public void setProof_of_fee_payment(String proof_of_fee_payment) {
		this.proof_of_fee_payment = proof_of_fee_payment;
	}

	@Override
	public String toString() {
		return "Institution [trademark_sample=" + trademark_sample + ", list_of_goods_and_services="
				+ list_of_goods_and_services + ", power_of_attorney=" + power_of_attorney
				+ ", general_power_of_attorney_previously_submitted=" + general_power_of_attorney_previously_submitted
				+ ", power_of_attorney_will_be_delivered_later=" + power_of_attorney_will_be_delivered_later
				+ ", general_act=" + general_act + ", proof_of_priority=" + proof_of_priority
				+ ", proof_of_fee_payment=" + proof_of_fee_payment + "]";
	}
	
	
	
	
}
