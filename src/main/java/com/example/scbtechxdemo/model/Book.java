package com.example.scbtechxdemo.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {

	private String author;
	private float price;
	private boolean isRecommended;

}
