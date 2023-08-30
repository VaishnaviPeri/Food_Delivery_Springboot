package com.nexturn.demo.ExceptionHandling;

public class CustomerException extends Exception {
	
	public CustomerException(){
		
	}
	
	public CustomerException(String msg) {
		super(msg);
	}

}
