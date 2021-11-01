package com.spring.association.springAssociations.dto;

import java.io.Serializable;

public class ReviewDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8604708640134329294L;

	private int id;
	
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
