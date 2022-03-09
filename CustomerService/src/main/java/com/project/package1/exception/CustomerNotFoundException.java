package com.project.package1.exception;


public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(String msg) {
		
		super(msg);
	}
}
