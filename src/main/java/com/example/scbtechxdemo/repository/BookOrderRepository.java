package com.example.scbtechxdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.scbtechxdemo.model.BookOrder;

public interface BookOrderRepository  extends JpaRepository<BookOrder, Long>{

	@Query(value = "SELECT *  FROM book_order b WHERE b.order_id = ?1", nativeQuery = true)
	 List<BookOrder>  findBookOrderByUserOrderId(Long id);
}
