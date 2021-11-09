package com.example.scbtechxdemo.controller.response;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import com.example.scbtechxdemo.model.Book;
import com.example.scbtechxdemo.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {

	private String name;
	private String surname;

	@JsonProperty("date_of_birth")
	private String dateOfBirth;

	private List<Long> books;

	public UserResponse(User user, List<Long> books) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.dateOfBirth = user.getDateOfBirth();
		this.books = books;
	}

}
