package com.example.scbtechxdemo.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scbtechxdemo.controller.request.BookRequest;
import com.example.scbtechxdemo.model.Book;
import com.example.scbtechxdemo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	BookService booksService;

	BookController(BookService booksService) {
		this.booksService = booksService;
	}

	@GetMapping
	public List<Book> getBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) {
		return booksService.getBookById(id);
	}

	@PostMapping
	public Book createBook(@RequestBody BookRequest bookRequest) {
		return booksService.createBook(bookRequest);
	}

	@PutMapping("/{id}")
	public Book getBooks(@RequestBody BookRequest bookRequest, @PathVariable long id) {
		return booksService.updateBook(bookRequest, id);
	}

	@DeleteMapping("/{id}")
	public void deleteBooks(@PathVariable long id) {
		booksService.deleteBook(id);
	}

}
