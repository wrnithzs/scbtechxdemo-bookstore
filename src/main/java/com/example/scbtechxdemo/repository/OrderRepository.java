package com.example.scbtechxdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.scbtechxdemo.controller.response.OrderResponse;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.model.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, Long>{
	
	@Query(value = "SELECT *  FROM user_order o WHERE o.user_id = ?1", nativeQuery = true)
	 List<UserOrder>  findOrderByUserId(Long id);
}
