package com.in28minutes.rest.webservices.restfulwebservices.requestchange;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class InvalidCoinCapacityException extends RuntimeException{
	
	public InvalidCoinCapacityException(String message) {
		super(message);
	}
}
