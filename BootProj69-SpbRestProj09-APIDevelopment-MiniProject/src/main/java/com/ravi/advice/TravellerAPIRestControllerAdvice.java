package com.ravi.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class TravellerAPIRestControllerAdvice {

	//advice method1
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> handleIAE(IllegalArgumentException iae,HttpServletRequest req){
		ErrorDetails details=new ErrorDetails();
		details.setMessage(iae.getMessage());
		details.setTimestamp(LocalDateTime.now());
		details.setPath(req.getServletPath());
		details.setStatusCode(500);
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//advice method1
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllException(Exception e,HttpServletRequest req){
		ErrorDetails details=new ErrorDetails();
		details.setMessage(e.getMessage());
		details.setTimestamp(LocalDateTime.now());
		details.setPath(req.getServletPath());
		details.setStatusCode(500);
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
