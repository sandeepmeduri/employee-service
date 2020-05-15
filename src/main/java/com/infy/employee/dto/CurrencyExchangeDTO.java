package com.infy.employee.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyExchangeDTO {

	private String from;
	
	private String to;
	
	private double conversion;
	
	public CurrencyExchangeDTO() {
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getConversion() {
		return conversion;
	}

	public void setConversion(double conversion) {
		this.conversion = conversion;
	}

	@Override
	public String toString() {
		return "CurrencyExchangeDTO [from=" + from + ", to=" + to + ", conversion=" + conversion + "]";
	}
	
}
