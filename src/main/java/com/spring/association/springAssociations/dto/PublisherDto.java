package com.spring.association.springAssociations.dto;

import java.io.Serializable;

public class PublisherDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9181513633607055150L;
	
	private int id;
	
	private String company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
