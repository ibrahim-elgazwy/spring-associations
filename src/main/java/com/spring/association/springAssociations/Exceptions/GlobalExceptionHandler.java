package com.spring.association.springAssociations.Exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.association.springAssociations.enums.ErrorCodeEnum;
import com.spring.association.springAssociations.enums.StatusEnum;
import com.spring.association.springAssociations.response.RestResponse;

/**
 * @author anuragdhunna
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BookStoreException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleBookStoreException(BookStoreException bookStoreException) {
		return new RestResponse(bookStoreException);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody RestResponse handleValidationExcption(MethodArgumentNotValidException exception) {
		//List<BookStoreError> errors = new ArrayList<BookStoreError>();
		
		List<BookStoreError> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> {
                	return new BookStoreError(
                			ErrorCodeEnum.getErrorCode(err.getCode()), 
                			err.getArguments());
                })
                .collect(Collectors.toList());
		
		return new RestResponse(errors, StatusEnum.ERROR);
	}
	
}