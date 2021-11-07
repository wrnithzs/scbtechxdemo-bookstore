package com.example.scbtechxdemo.controller.request;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookRequest {
	@NotBlank(message = "is Empty")
	private String name;

	@NotBlank(message = "is Empty")
	private String author;

	@NotNull(message = "is Empty")
	@Min(0)
	private BigDecimal price;
	private Boolean isRecommended = false;
}
