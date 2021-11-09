package com.example.scbtechxdemo.exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(String username) {
		super("could not find username : " + username);

	}
	public UserNotFoundException() {
		super("User not found.");

	}
}