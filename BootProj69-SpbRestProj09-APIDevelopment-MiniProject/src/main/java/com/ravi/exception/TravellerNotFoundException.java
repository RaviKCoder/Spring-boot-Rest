package com.ravi.exception;

public class TravellerNotFoundException extends RuntimeException {

	public TravellerNotFoundException(String message) {
		super(message);
	}
	
	public TravellerNotFoundException() {
		super();
	}
	
	

}
