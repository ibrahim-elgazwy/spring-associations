package com.spring.association.springAssociations.Exceptions;

import com.spring.association.springAssociations.enums.ErrorCodeEnum;

public class UnauthorizedException extends BookStoreException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4002055037626707380L;

	public UnauthorizedException() {
        super(ErrorCodeEnum.UNUATHORIZED_USER);
    }

}
