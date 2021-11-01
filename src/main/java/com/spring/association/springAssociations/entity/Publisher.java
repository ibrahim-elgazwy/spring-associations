package com.spring.association.springAssociations.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="publisher")
public class Publisher implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4123570015132120762L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company")
	private String company;
	
	@OneToMany(mappedBy = "publisher", 
			   fetch = FetchType.LAZY)
	@OrderBy("price DESC")
	private Set<Book> books;

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

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		books.forEach(book -> book.setPublisher(this));
		this.books = books;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", company=" + company + "]";
	}
}
