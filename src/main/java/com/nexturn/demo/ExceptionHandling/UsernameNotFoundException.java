package com.nexturn.demo.ExceptionHandling;

public class UsernameNotFoundException extends Exception {
	
	public UsernameNotFoundException(String message) {
		super(message);
	}
	
	public UsernameNotFoundException(String message, Exception cause) {
        super(message, cause);
    }

}
