package com.example.scbtechxdemo.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private long orderId; // UserOrder
	private long bookId; // Book
	private BigDecimal price;
}
