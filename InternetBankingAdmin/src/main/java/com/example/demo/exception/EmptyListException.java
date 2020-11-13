package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyListException extends Exception {
	public EmptyListException() {
		super();
	}
	
	public EmptyListException(String message) {
		super(message);
	}
	
	public EmptyListException(String message, Throwable clause) {
		super(message, clause);
	}
	
	public EmptyListException(Throwable clause) {
		super(clause);
	}


}
