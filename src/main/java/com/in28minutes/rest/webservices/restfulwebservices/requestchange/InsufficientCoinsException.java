package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InsufficientCoinsException extends RuntimeException{
	
	public InsufficientCoinsException(String message) {
		super(message);
	}

}
