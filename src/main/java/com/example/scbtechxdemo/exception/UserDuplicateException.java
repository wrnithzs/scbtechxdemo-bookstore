package com.example.scbtechxdemo.exception;

public class UserDuplicateException extends RuntimeException{
	
	public UserDuplicateException(String username) {
		super("Username: " + username + " already exists.");

	}
}
