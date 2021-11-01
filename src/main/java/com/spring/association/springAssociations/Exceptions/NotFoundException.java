package com.spring.association.springAssociations.Exceptions;

import com.spring.association.springAssociations.enums.ErrorCodeEnum;

public class NotFoundException extends BookStoreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6921461021074807781L;

	public NotFoundException() {
		super(ErrorCodeEnum.HTTP_STATUS_404_NOT_FOUND);
	}

}
