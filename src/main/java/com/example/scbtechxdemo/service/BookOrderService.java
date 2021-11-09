package com.example.scbtechxdemo.service;

import java.util.List;

import com.example.scbtechxdemo.model.BookOrder;

public interface BookOrderService {
   List<BookOrder> getBookOrderByUserOrderId(Long id);
}
