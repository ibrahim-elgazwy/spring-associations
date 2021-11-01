package com.spring.association.springAssociations.Exceptions;

import com.spring.association.springAssociations.enums.ErrorCodeEnum;

public class InvalidRequestIdException extends BookStoreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3324845443631576309L;

	public InvalidRequestIdException() {
		super(ErrorCodeEnum.NOT_FOIND_REQUEST_ID);
	}
}
