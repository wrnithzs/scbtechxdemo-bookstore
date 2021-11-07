package com.example.scbtechxdemo.service;

import java.util.List;

import com.example.scbtechxdemo.controller.request.BookRequest;
import com.example.scbtechxdemo.model.Book;

public interface BookService {

	List<Book> getAllBooks();

	Book getBookById(Long id);

	Book createBook(BookRequest bookRequest);

	Book updateBook(BookRequest bookRequest, Long id);

	void deleteBook(Long id);
}
