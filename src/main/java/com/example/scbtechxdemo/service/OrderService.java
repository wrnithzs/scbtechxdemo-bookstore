package com.example.scbtechxdemo.service;

import java.util.List;

import com.example.scbtechxdemo.controller.request.OrderRequest;
import com.example.scbtechxdemo.controller.response.OrderResponse;
import com.example.scbtechxdemo.model.User;

public interface OrderService {

	OrderResponse createOrder(OrderRequest orderRequest, User user);
	List<Long> findBookIdFromOrderByUserId(Long id);
	
	void deleteOrderByUserId(Long id);
}
