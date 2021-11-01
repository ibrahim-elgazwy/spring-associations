package com.spring.association.springAssociations.enums;

import java.io.Serializable;

public enum StatusEnum implements Serializable {
	
	OK("OK"), ERROR("ERROR");
	private final String statusTxt;

	private StatusEnum(String statusTxt) {
		this.statusTxt = statusTxt;
	}

	@Override
	public String toString() {
		return statusTxt;
	}
}
