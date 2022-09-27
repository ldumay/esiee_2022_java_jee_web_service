package com.example.restservice.exception;

public class NoGreetingFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoGreetingFoundException() {
		super("Greeting not found");
	}

	public NoGreetingFoundException(Long id) {
		super("Greeting with id " + id + " is not found");
	}

}
