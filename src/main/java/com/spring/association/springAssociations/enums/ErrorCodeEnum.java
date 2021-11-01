package com.spring.association.springAssociations.enums;

public enum ErrorCodeEnum {
	UNUATHORIZED_USER(
			"UNUATHORIZED_USER", 
			"unauthorized user, user must be login", 
			"user must be login"),
	HTTP_STATUS_404_NOT_FOUND(
			"HTTP_STATUS_404_NOT_FOUND", 
			 "The origin server did not find a current representation for the target resource", 
			 "check resource url"),
	NOT_FOIND_REQUEST_ID(
			"NOT_FOIND_REQUEST_ID", 
			"request id not founded, please check valid request id", 
			"check request id"),
	GENRE_MUST_BE_NOT_EMPTY(
			"GENRE_MUST_BE_NOT_EMPTY", 
			"Please provide author genre value", 
			"Please provide author genre value"),
	AGE_MUST_BE_NOT_EMPTY(
			"AGE_MUST_BE_NOT_EMPTY",
			"Please provide author age value",
			"Please provide author genre value"
	);
	
	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	
	private ErrorCodeEnum(String errorCode, 
						  String errorDescription, 
						  String fixSuggestion) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
		this.fixSuggestion = fixSuggestion;
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

	public static ErrorCodeEnum getErrorCode(String code) {
		return ErrorCodeEnum.valueOf(code);
	}
}
