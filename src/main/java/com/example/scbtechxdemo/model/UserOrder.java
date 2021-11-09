package com.example.scbtechxdemo.model;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class UserOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private long userId; // User
	private BigDecimal totalPrice;
}