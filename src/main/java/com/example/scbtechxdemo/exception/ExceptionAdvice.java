package com.example.scbtechxdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String handlerBookException(BookNotFoundException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handlerValidation(ValidationException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handlerUserDuplicate(UserDuplicateException ex) {
		return ex.getMessage();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String handlerUserException(UserNotFoundException ex) {
		return ex.getMessage();
	}
}
