package com.spring.association.springAssociations.response;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.association.springAssociations.Exceptions.BookStoreException;
import com.spring.association.springAssociations.enums.StatusEnum;

public class RestResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3471528248070167046L;
	
	private StatusEnum status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime  timestamp;
	private String errorCode;
	private String errorDescription;
	private String fixSuggestion;
	private Object body;

	public RestResponse(Object body) {
		if (body instanceof BookStoreException) {
			BookStoreException bookStoreException = (BookStoreException) body;
			status = StatusEnum.ERROR;
			errorCode = bookStoreException.getErrorCode();
			errorDescription = bookStoreException.getErrorDescription();
		} 
		
		this.body = body;
	}
	
	public RestResponse(Object body, StatusEnum status) {
		this.status = status;
		this.body = body;
	}
	
	public RestResponse(String errorCode, String errorDescription) {
		this.status = StatusEnum.ERROR;
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public StatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	public LocalDateTime  getTimestamp() {
		return LocalDateTime.now();
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
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
	
	public String getFixSuggestion() {
		return fixSuggestion;
	}
	public void setFixSuggestion(String fixSuggestion) {
		this.fixSuggestion = fixSuggestion;
	}
	
	public Object getBody() {
		return body;
	}
	
	public void setBody(Object body) {
		this.body = body;
	}
}
