package com.spring.association.springAssociations.service;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.dto.AuthorDto;
import com.spring.association.springAssociations.dto.BookDto;
import com.spring.association.springAssociations.entity.Author;
import com.spring.association.springAssociations.entity.Book;

public interface AuthorService {
	AuthorDto addNewAuthor(Author author);
	
	AuthorDto findById(int id) throws BookStoreException;
	
	BookDto addNewBook(int id, Book book) throws BookStoreException;
}
