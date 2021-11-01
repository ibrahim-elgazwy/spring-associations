package com.spring.association.springAssociations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.dto.BookDto;
import com.spring.association.springAssociations.entity.Book;
import com.spring.association.springAssociations.entity.Publisher;
import com.spring.association.springAssociations.entity.Review;
import com.spring.association.springAssociations.enums.ErrorCodeEnum;
import com.spring.association.springAssociations.response.RestResponse;
import com.spring.association.springAssociations.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping
	public RestResponse getAllBooks(
		      @RequestParam(defaultValue = "0") int page,
		      @RequestParam(defaultValue = "5") int size) throws BookStoreException {
		Pageable pagingSort = PageRequest.of(page, size, 
				Sort.by(Sort.Direction.DESC, "title"));
		Page<Book> books = bookService.findAll(pagingSort);
		
		if(books.getContent().isEmpty()) {
			throw new BookStoreException(ErrorCodeEnum.UNUATHORIZED_USER);
		}
		
		return new RestResponse(bookService.getMappedBookDto(books));
	}
	
	@PostMapping("/{id}/add-publisher")
	public RestResponse addPublisher(
			@PathVariable int id,
			@RequestBody Publisher publisher) throws BookStoreException {
		
		 BookDto book = bookService.addPublisher(id, publisher);
		 return new RestResponse(book);
	}
	
	@PostMapping("/{id}/add-review")
	public RestResponse addBookReview(
			@PathVariable int id,
			@RequestBody Review review) throws BookStoreException {
		
		 BookDto book = bookService.addBookReview(id, review);
		 return new RestResponse(book);
	}
}
