package com.example.scbtechxdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.controller.request.BookRequest;
import com.example.scbtechxdemo.exception.BookNotFoundException;
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
		throw new BookNotFoundException(id);
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
		throw new BookNotFoundException(id);
	}

	@Override
	public void deleteBook(Long id) {
		try {
			booksRepository.deleteById(id);
		} catch (Exception e) {
			throw new BookNotFoundException(id);
		}

	}

	@Override
	public List<Book> getAllBooksSortByNameAndRecommended() {
		List<Order> orders = new ArrayList<Order>();

		Order isRecommended = new Order(Sort.Direction.DESC, "isRecommended");
		orders.add(isRecommended);
		Order name = new Order(Sort.Direction.ASC, "name");
		orders.add(name);

		return booksRepository.findAll(Sort.by(orders));

	}

}
