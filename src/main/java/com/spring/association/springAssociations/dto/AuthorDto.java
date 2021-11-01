package com.spring.association.springAssociations.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class AuthorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2858389457302707365L;
	
	private int id;

	private String name;

	private String genre;

	private int age;
	
	private AuthorDetailDto authorDetail;
	
	private Set<BookDto> books = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public AuthorDetailDto getAuthorDetail() {
		return authorDetail;
	}

	public void setAuthorDetail(AuthorDetailDto authorDetail) {
		this.authorDetail = authorDetail;
	}

	public Set<BookDto> getBooks() {
		return books;
	}

	public void setBooks(Set<BookDto> books) {
		this.books = books;
	}
}
