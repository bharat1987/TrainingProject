package com.msproject.exception;


public class UserIdAlreadyPresentException extends Exception {
	public UserIdAlreadyPresentException(String message){
		super(message);
	}
}
