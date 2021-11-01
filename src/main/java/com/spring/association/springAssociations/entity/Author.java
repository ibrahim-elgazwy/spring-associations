package com.spring.association.springAssociations.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "author")
@NamedEntityGraph(
		name="author-books", 
	    attributeNodes = {
	    	  @NamedAttributeNode(value = "authorDetail"),
    		  @NamedAttributeNode(
    				  value = "books",
    				  subgraph = "publisher-subgraph"
    		   )
	    }, 
	    subgraphs = {
	    		@NamedSubgraph(
	    				name="publisher-subgraph",
	    				attributeNodes = {
	    					@NamedAttributeNode(value = "publisher")
	    				}
	    		)
	    }
)
public class Author implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3837266033061278381L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "genre")
	private String genre;

	@Column(name = "age")
	private int age;

	@OneToMany(mappedBy = "author", 
			   fetch = FetchType.LAZY, 
			   cascade = CascadeType.ALL, 
			   orphanRemoval = true)
	@OrderColumn(name = "id")
	@Where(clause = "price > 5")
	@OrderBy("price DESC")
	private Set<Book> books = new HashSet<Book>();
	
	@OneToOne(mappedBy = "author", 
			  fetch = FetchType.LAZY, 
			  cascade = CascadeType.ALL)
	private AuthorDetail authorDetail;

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

	public void addBook(Book book) {
		this.books.add(book);
		book.setAuthor(this);
	}

	public void removeBook(Book book) {
		book.setAuthor(null);
		this.books.remove(book);
	}

	public void removeBooks() {
		Iterator<Book> iterator = this.books.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			book.setAuthor(null);
			iterator.remove();
		}
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public AuthorDetail getAuthorDetail() {
		authorDetail.setAuthor(this);
		return authorDetail;
	}

	public void setAuthorDetail(AuthorDetail authorDetail) {
		this.authorDetail = authorDetail;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", genre=" + genre + ", age=" + age + "]";
	}
}
