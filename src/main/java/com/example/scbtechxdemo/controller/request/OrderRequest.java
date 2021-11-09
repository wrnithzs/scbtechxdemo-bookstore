package com.example.scbtechxdemo.controller.request;

import java.math.BigDecimal;
import java.util.List;

import com.example.scbtechxdemo.model.Book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
	private List<Long> orders;
}
