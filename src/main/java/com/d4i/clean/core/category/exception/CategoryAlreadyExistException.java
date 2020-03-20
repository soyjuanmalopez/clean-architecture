package com.d4i.clean.core.category.exception;

import org.springframework.http.HttpStatus;

import com.d4i.clean.infraestructure.shared.exceptions.NetflixException;

import lombok.Data;

@Data
public class CategoryAlreadyExistException extends NetflixException{
	
	private static final long serialVersionUID = -5330068136795055851L;

	public CategoryAlreadyExistException(final String message) {
		super(HttpStatus.BAD_REQUEST.value(), message);
	}


}
