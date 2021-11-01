package com.spring.association.springAssociations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.dto.AuthorDto;
import com.spring.association.springAssociations.dto.BookDto;
import com.spring.association.springAssociations.entity.Author;
import com.spring.association.springAssociations.entity.Book;
import com.spring.association.springAssociations.response.RestResponse;
import com.spring.association.springAssociations.service.AuthorService;
import com.spring.association.springAssociations.validator.AuthorValidator;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private AuthorValidator authorValidator;

	@InitBinder()
	private void correctSakUserControllerInitBinder(WebDataBinder binder) {
		binder.setValidator(authorValidator);
	}
	
	@PostMapping
	public RestResponse addNewAuthor(@Validated @RequestBody Author author) throws Exception {
		AuthorDto authorDto = authorService.addNewAuthor(author);
		return new RestResponse(authorDto);
	}
	
	@PostMapping("/addBook/{id}")
	public RestResponse addNewBookToAuthor(
			@PathVariable int id,
			@RequestBody Book book) throws BookStoreException {
		BookDto newBook = authorService.addNewBook(id, book);
		return new RestResponse(newBook);
	}
	
	@GetMapping("/{id}")
	public RestResponse findAuthorById(@PathVariable int id) throws BookStoreException {
		AuthorDto authorDto = authorService.findById(id);
		return new RestResponse(authorDto);
	}
}
