package com.spring.association.springAssociations.Exceptions;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class BookStoreExceptionSerializer extends StdSerializer<BookStoreException> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3531948108075813563L;

	public BookStoreExceptionSerializer() {
		this(null);
	}
	
	public BookStoreExceptionSerializer(Class<BookStoreException> t) {
		super(t);
	}
	
	protected BookStoreExceptionSerializer(Class<BookStoreException> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(BookStoreException bookStoreException, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonGenerationException {
		System.out.println(bookStoreException.toString());
		jgen.writeStartObject();
        jgen.writeStringField("errorCode", bookStoreException.getErrorCode() == null ? "" : bookStoreException.getErrorCode());
        jgen.writeStringField("errorDescription", bookStoreException.getErrorDescription() == null ? "" : bookStoreException.getErrorDescription());

        jgen.writeEndObject();
		
	}
}
