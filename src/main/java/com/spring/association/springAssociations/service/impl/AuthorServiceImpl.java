package com.spring.association.springAssociations.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.dto.AuthorDto;
import com.spring.association.springAssociations.dto.BookDto;
import com.spring.association.springAssociations.entity.Author;
import com.spring.association.springAssociations.entity.Book;
import com.spring.association.springAssociations.enums.ErrorCodeEnum;
import com.spring.association.springAssociations.repository.AuthorRepository;
import com.spring.association.springAssociations.service.AuthorService;
import com.spring.association.springAssociations.service.BookService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional
	public AuthorDto addNewAuthor(Author author) {
		author.getBooks().forEach(book -> book.setAuthor(author));
		Author newAuthor = authorRepository.save(author);
		return modelMapper.map(newAuthor, AuthorDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public AuthorDto findById(int id) throws BookStoreException {
		
		Author author = authorRepository
				.findById(id)
				.orElseThrow(
						() -> new BookStoreException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID)
				);
		return modelMapper.map(author, AuthorDto.class);
	}

	@Override
	@Transactional
	public BookDto addNewBook(int id, Book book) throws BookStoreException {
		return bookService.addNewBookToAuthor(id, book);
	}
}
