package com.example.scbtechxdemo.exception;

public class BookNotFoundException extends RuntimeException {
	public BookNotFoundException(long id) {
		super("Could not find bookid " + id);

	}
}
