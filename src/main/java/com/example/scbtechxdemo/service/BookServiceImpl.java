package com.example.scbtechxdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.controller.request.BookRequest;
import com.example.scbtechxdemo.model.Book;
import com.example.scbtechxdemo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	BookRepository booksRepository;

	BookServiceImpl(BookRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	@Override
	public List<Book> getAllBooks() {

		return booksRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> book = booksRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		}
		return new Book();
	}

	@Override
	public Book createBook(BookRequest bookRequest) {
		Book book = new Book();
		book.setName(bookRequest.getName());
		book.setAuthor(bookRequest.getAuthor());
		book.setPrice(bookRequest.getPrice());
		book.setIsRecommended(bookRequest.getIsRecommended());

		return booksRepository.save(book);
	}

	@Override
	public Book updateBook(BookRequest bookRequest, Long id) {
		Optional<Book> book = booksRepository.findById(id);

		if (book.isPresent()) {
			Book existingBook = book.get();
			existingBook.setName(bookRequest.getName());
			existingBook.setAuthor(bookRequest.getAuthor());
			existingBook.setPrice(bookRequest.getPrice());
			existingBook.setIsRecommended(bookRequest.getIsRecommended());
			return booksRepository.save(existingBook);
		}
		return new Book();
	}

	@Override
	public void deleteBook(Long id) {
		booksRepository.deleteById(id);
	}

}
