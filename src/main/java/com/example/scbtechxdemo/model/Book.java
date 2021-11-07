package com.example.scbtechxdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String author;
	private float price;
	@JsonProperty("is_recommended")
	private Boolean isRecommended;

}
