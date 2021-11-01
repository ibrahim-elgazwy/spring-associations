package com.spring.association.springAssociations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.enums.ErrorCodeEnum;
import com.spring.association.springAssociations.response.RestResponse;

@RestController
@RequestMapping("/error")
public class ErrorController {
	@GetMapping
	public RestResponse handleGetError() throws BookStoreException {
		throw new BookStoreException(ErrorCodeEnum.HTTP_STATUS_404_NOT_FOUND);
	}
	
	@PostMapping
	public RestResponse handlePostError() throws BookStoreException {
		throw new BookStoreException(ErrorCodeEnum.HTTP_STATUS_404_NOT_FOUND);
	}
}
