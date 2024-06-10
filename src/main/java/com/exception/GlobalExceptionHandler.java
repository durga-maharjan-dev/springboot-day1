package com.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeIdNegativeException.class)
	public ResponseEntity<String> handleEmployeeIdNegativeException(EmployeeIdNegativeException ex, WebRequest webRequest){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<?> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest webRequest){
		ApplicationStatus applicationStatus = new ApplicationStatus(new Date(), ex.getMessage(),"NOT_FOUND",webRequest.getDescription(true));
		return new ResponseEntity<>(applicationStatus,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeIdNotFoundException.class)
	public ResponseEntity<?> handleEmployeeIdNotFoundException(EmployeeIdNotFoundException ex, WebRequest webRequest){
		ApplicationStatus applicationStatus = new ApplicationStatus(new Date(), ex.getMessage(),"NOT_FOUND",webRequest.getDescription(true));
		return new ResponseEntity<>(applicationStatus,HttpStatus.NOT_FOUND);
	}

}
