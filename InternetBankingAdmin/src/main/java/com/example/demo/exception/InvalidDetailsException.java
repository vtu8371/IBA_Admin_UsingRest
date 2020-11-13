package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidDetailsException extends Exception {
	public InvalidDetailsException() {
		super();
	}
	
	public InvalidDetailsException(String message) {
		super(message);
	}
	
	public InvalidDetailsException(String message, Throwable clause) {
		super(message, clause);
	}
	
	public InvalidDetailsException(Throwable clause) {
		super(clause);
	}

}
