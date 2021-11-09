package com.example.scbtechxdemo.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scbtechxdemo.controller.request.BookRequest;
import com.example.scbtechxdemo.controller.response.BookResponse;
import com.example.scbtechxdemo.exception.ValidationException;
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
	public BookResponse getBooks() {
		return booksService.getAllBooksSortByNameAndRecommended();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) {
		return booksService.getBookById(id);
	}

	@PostMapping
	public Book createBook(@Valid @RequestBody BookRequest bookRequest, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream().forEach(fieldError -> {
				throw new ValidationException(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			});
		}
		return booksService.createBook(bookRequest);
	}

	@PutMapping("/{id}")
	public Book updateBooks(@Valid @RequestBody BookRequest bookRequest, BindingResult bindingResult,
			@PathVariable long id) {
		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream().forEach(fieldError -> {
				throw new ValidationException(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			});
		}
		return booksService.updateBook(bookRequest, id);
	}

	@DeleteMapping("/{id}")
	public void deleteBooks(@PathVariable long id) {
		booksService.deleteBook(id);
	}

}
