package com.example.scbtechxdemo.controller.response;

import java.math.BigDecimal;

import com.example.scbtechxdemo.model.UserOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {

	private BigDecimal price;

	public OrderResponse(UserOrder order) {
		this.price = order.getTotalPrice();
	}
}
