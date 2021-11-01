package com.spring.association.springAssociations.validator;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.association.springAssociations.entity.Author;
import com.spring.association.springAssociations.enums.ErrorCodeEnum;

@Component
public class AuthorValidator implements Validator, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5491972399063307894L;

	@Override
	public boolean supports(Class<?> clazz) {
		return Author.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Author authorDto = (Author) target;
		
		if(authorDto.getAge() == 0) {
			errors.rejectValue("age", ErrorCodeEnum.AGE_MUST_BE_NOT_EMPTY.getErrorCode(), null, null);
			return;
		}
		
		if(authorDto.getGenre().isBlank() || authorDto.getGenre().isEmpty()) {
			errors.rejectValue("genre", ErrorCodeEnum.GENRE_MUST_BE_NOT_EMPTY.getErrorCode(), null, null);
			return;
		}
	}

}
