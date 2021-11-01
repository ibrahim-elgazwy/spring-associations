package com.spring.association.springAssociations.dto;

import java.io.Serializable;
import java.util.Set;

public class BookDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 531177772044486858L;

	private int id;

	private String title;

	private String isbn;

	private double price;
	
	private PublisherDto publisher;
	
	private Set<ReviewDto> reviews;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PublisherDto getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherDto publisher) {
		this.publisher = publisher;
	}

	public Set<ReviewDto> getReviews() {
		return reviews;
	}

	public void setReviews(Set<ReviewDto> reviews) {
		this.reviews = reviews;
	}	
}
