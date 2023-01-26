package com.xml.zig.zigbackapp.model;

public class TrademarkColor {
	
	private String trademark_color;

	
	
	public TrademarkColor() {
	}

	public TrademarkColor(String trademark_color) {
		this.trademark_color = trademark_color;
	}

	public String getTrademark_color() {
		return trademark_color;
	}

	public void setTrademark_color(String trademark_color) {
		this.trademark_color = trademark_color;
	}

	@Override
	public String toString() {
		return "TrademarkColor [trademark_color=" + trademark_color + "]";
	} 
	
	
	
}
