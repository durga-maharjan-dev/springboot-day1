package com.exception;

import java.util.Date;

public class ApplicationStatus {
	
	private Date currentDateTime;
	private String message;
	private String statusCode; 
	private String request;
	
	
	
	

	public ApplicationStatus(Date currentDateTime, String message, String statusCode, String request) {
		super();
		this.currentDateTime = currentDateTime;
		this.message = message;
		this.statusCode = statusCode;
		this.request = request;
	}


	public ApplicationStatus() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Date getCurrentDateTime() {
		return currentDateTime;
	}


	public void setCurrentDateTime(Date currentDateTime) {
		this.currentDateTime = currentDateTime;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getRequest() {
		return request;
	}


	public void setRequest(String request) {
		this.request = request;
	}
	
	
	


	
	

}
