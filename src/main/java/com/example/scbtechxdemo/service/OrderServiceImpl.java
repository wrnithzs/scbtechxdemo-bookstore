package com.example.scbtechxdemo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.controller.request.OrderRequest;
import com.example.scbtechxdemo.controller.response.OrderResponse;
import com.example.scbtechxdemo.model.Book;
import com.example.scbtechxdemo.model.BookOrder;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.model.UserOrder;
import com.example.scbtechxdemo.repository.BookOrderRepository;
import com.example.scbtechxdemo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private BookService booksService;
	private BookOrderService bookOrderService;
	private BookOrderRepository bookOrderRepository;

	OrderServiceImpl(OrderRepository orderRepository, BookService booksService, BookOrderService bookOrderService,
			BookOrderRepository bookOrderRepository) {
		this.orderRepository = orderRepository;
		this.booksService = booksService;
		this.bookOrderService = bookOrderService;
		this.bookOrderRepository = bookOrderRepository;
	}

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest, User user) {

		List<Long> orders = orderRequest.getOrders();
		List<Book> books = new ArrayList<Book>();

		BigDecimal totalPrice = new BigDecimal(0);

		for (Long bookId : orders) {
			Book book = this.booksService.getBookById(bookId);
			books.add(book);
			totalPrice = totalPrice.add(book.getPrice());
		}
		UserOrder order = new UserOrder();
		order.setUserId(user.getId());
		order.setTotalPrice(totalPrice);
		order = this.orderRepository.save(order);

		for (Book book : books) {
			BookOrder bookOrder = new BookOrder();
			bookOrder.setBookId(book.getId());
			bookOrder.setOrderId(order.getId());
			bookOrder.setPrice(book.getPrice());

			bookOrderRepository.save(bookOrder);
		}

		return new OrderResponse(order);
	}

	@Override
	public List<Long> findBookIdFromOrderByUserId(Long id) {

		List<UserOrder> orders = orderRepository.findOrderByUserId(id);

		List<Long> books = new ArrayList<Long>();

		for (UserOrder order : orders) {

			List<BookOrder> bookOrders = bookOrderService.getBookOrderByUserOrderId(order.getId());

			for (BookOrder bookOrder : bookOrders) {

				long bookId = bookOrder.getBookId();
				books.add(bookId);
			}
		}
		return books;
	}

	@Override
	public void deleteOrderByUserId(Long id) {
		List<UserOrder> orders = orderRepository.findOrderByUserId(id);
		orderRepository.deleteAll(orders);
	}

}
