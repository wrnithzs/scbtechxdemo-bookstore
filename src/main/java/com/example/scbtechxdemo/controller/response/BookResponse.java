package com.example.scbtechxdemo.controller.response;

import java.util.List;

import com.example.scbtechxdemo.model.Book;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookResponse {
	List<Book> books ;

	public BookResponse(List<Book> books) {
		this.books = books;
	}
	
}
