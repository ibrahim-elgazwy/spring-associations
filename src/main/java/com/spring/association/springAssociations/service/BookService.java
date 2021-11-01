package com.spring.association.springAssociations.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.dto.BookDto;
import com.spring.association.springAssociations.entity.Book;
import com.spring.association.springAssociations.entity.Publisher;
import com.spring.association.springAssociations.entity.Review;

public interface BookService {
	Page<Book> findAll(Pageable pageable);
	
	BookDto addNewBookToAuthor(int id, Book book) throws BookStoreException;
	
	BookDto addPublisher(int id, Publisher bublisher) throws BookStoreException;
	
	BookDto addBookReview(int id, Review review) throws BookStoreException;
	
	Object getMappedBookDto(Page<Book> books);
}
