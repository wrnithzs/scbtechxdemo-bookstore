package com.example.scbtechxdemo.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookRequest {

	private String name;
	private String author;
	private float price;
	private Boolean isRecommended;
}
