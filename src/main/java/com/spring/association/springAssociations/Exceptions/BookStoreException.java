package com.spring.association.springAssociations.Exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.spring.association.springAssociations.enums.ErrorCodeEnum;

@JsonSerialize(using = BookStoreExceptionSerializer.class)
public class BookStoreException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1915592907892019951L;
	
	protected String errorCode;
	protected String errorDescription;

	public BookStoreException(ErrorCodeEnum errorCodeEnum) {
		errorCode = errorCodeEnum.getErrorCode();
		errorDescription = errorCodeEnum.getErrorDescription();
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getErrorDescription() {
		return errorDescription;
	}
	
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
