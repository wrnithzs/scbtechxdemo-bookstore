package com.example.scbtechxdemo.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.example.scbtechxdemo.model.BookOrder;
import com.example.scbtechxdemo.repository.BookOrderRepository;

@Service
public class BookOrderServiceImpl implements BookOrderService {

	
	private BookOrderRepository bookOrderRepository;
	BookOrderServiceImpl (BookOrderRepository bookOrderRepository){
		this.bookOrderRepository = bookOrderRepository;
		
	}
	@Override
	public List<BookOrder> getBookOrderByUserOrderId(Long id) {
		List<BookOrder> bookOrders = bookOrderRepository.findBookOrderByUserOrderId(id);
		return bookOrders;
	}

}
