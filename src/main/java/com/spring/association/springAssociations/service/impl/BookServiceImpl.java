package com.spring.association.springAssociations.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.dto.BookDto;
import com.spring.association.springAssociations.entity.Author;
import com.spring.association.springAssociations.entity.Book;
import com.spring.association.springAssociations.entity.Publisher;
import com.spring.association.springAssociations.entity.Review;
import com.spring.association.springAssociations.enums.ErrorCodeEnum;
import com.spring.association.springAssociations.repository.AuthorRepository;
import com.spring.association.springAssociations.repository.BookRepository;
import com.spring.association.springAssociations.repository.ReviewRepository;
import com.spring.association.springAssociations.service.BookService;
import com.spring.association.springAssociations.utils.Pageing;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookDto addNewBookToAuthor(int id, Book book) throws BookStoreException {
		Author author = authorRepository
				.findById(id)
				.orElseThrow(() -> new BookStoreException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID));
		
		book.setAuthor(author);
		Book newBook = bookRepository.save(book);
		return modelMapper.map(newBook, BookDto.class);
	}

	@Override
	public BookDto addPublisher(int id, Publisher publisher) throws BookStoreException {
		Book book = bookRepository
				.findById(id)
				.orElseThrow(() -> new BookStoreException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID));
		
		book.setPublisher(publisher);
		book = bookRepository.save(book);
		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	public Object getMappedBookDto(Page<Book> books) {
		Map<String, Object> response = new HashMap<>(); 
		List<BookDto> bookDtos = new ArrayList<BookDto>();
		Pageing pageing = new Pageing(books);
		
		System.out.println(books.getContent().get(0).getReviews());
		
		bookDtos = books.getContent()
				.stream()
				.map(book -> modelMapper.map(book, BookDto.class))
				.collect(Collectors.toList());
	
		response.put("pageing", pageing);
		response.put("data", bookDtos);
		return response;
	}

	@Override
	public BookDto addBookReview(int id, Review review) throws BookStoreException {
		Book book = bookRepository
					.findById(id)
					.orElseThrow(
						() -> new BookStoreException(ErrorCodeEnum.NOT_FOIND_REQUEST_ID)
					);
		
		review.setBook(book);
		reviewRepository.save(review);
		
		return modelMapper.map(book, BookDto.class);
	}
}
