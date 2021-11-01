package com.spring.association.springAssociations.Exceptions;

import java.io.Serializable;

import com.spring.association.springAssociations.enums.ErrorCodeEnum;

public class BookStoreError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5833182580071636007L;

	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	private Object target;
	private Object errorArguments;

	public BookStoreError(ErrorCodeEnum errorCodeEnum, Object errorArguments) {
//		this.target = target;
		this.errorCode = errorCodeEnum.getErrorCode();
		this.errorDescription = errorCodeEnum.getErrorDescription();
		this.fixSuggestion = errorCodeEnum.getFixSuggestion();
		this.errorArguments = errorArguments;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getFixSuggestion() {
		return fixSuggestion;
	}

	public Object getTarget() {
		return target;
	}

	public Object getErrorArguments() {
		return errorArguments;
	}
}
