package com.xml.zig.zigbackapp.dto.request.trademark_save_dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.xml.zig.zigbackapp.model.Document;
import com.xml.zig.zigbackapp.model.TrademarkAppearance;
import com.xml.zig.zigbackapp.model.TrademarkColor;
import com.xml.zig.zigbackapp.model.TrademarkType;

public class TrademarkInfo {

	private TrademarkType trademark_type;
	
	private TrademarkAppearance trademark_appearance;
	
	private String trademark_view;
	
//	@JacksonXmlProperty(localName = "trademark_color")
	private List<TrademarkColor> trademark_colors = new ArrayList<TrademarkColor>();
	
	private String trademark_transliteration;
	
	private String trademark_translation;
	
	private String trademark_description;
	

	public TrademarkType getTrademark_type() {
		return trademark_type;
	}

	public void setTrademark_type(TrademarkType trademark_type) {
		this.trademark_type = trademark_type;
	}

	public TrademarkAppearance getTrademark_appearance() {
		return trademark_appearance;
	}

	public void setTrademark_appearance(TrademarkAppearance trademark_appearance) {
		this.trademark_appearance = trademark_appearance;
	}

	public String getTrademark_view() {
		return trademark_view;
	}

	public void setTrademark_view(String trademark_view) {
		this.trademark_view = trademark_view;
	}

	public List<TrademarkColor> getTrademark_colors() {
		return trademark_colors;
	}

	public void setTrademark_colors(ArrayList<TrademarkColor> trademark_colors) {
		this.trademark_colors = trademark_colors;
	}

	public String getTrademark_transliteration() {
		return trademark_transliteration;
	}

	public void setTrademark_transliteration(String trademark_transliteration) {
		this.trademark_transliteration = trademark_transliteration;
	}

	public String getTrademark_translation() {
		return trademark_translation;
	}

	public void setTrademark_translation(String trademark_translation) {
		this.trademark_translation = trademark_translation;
	}

	public String getTrademark_description() {
		return trademark_description;
	}

	public void setTrademark_description(String trademark_description) {
		this.trademark_description = trademark_description;
	}

	@Override
	public String toString() {
		return "TrademarkInfo [trademark_type=" + trademark_type + ", trademark_appearance=" + trademark_appearance
				+ ", trademark_view=" + trademark_view + ", trademark_colors=" + trademark_colors
				+ ", trademark_transliteration=" + trademark_transliteration + ", trademark_translation="
				+ trademark_translation + ", trademark_description=" + trademark_description + "]";
	}
	
	
	
}
