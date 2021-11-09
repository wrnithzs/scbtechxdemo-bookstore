package com.example.scbtechxdemo.controller.request;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.model.Book;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Service
@NoArgsConstructor
public class UserRequest {
	@NotBlank
	@Size(min = 1, max = 100)
	private String username;
	
	@NotBlank
	@Length(min = 6, message = "The field must be at least {min} characters")
	private String password;
	
	private String role = "user" ;
	private String name;
	private String surname;
	private String date_of_birth;
	private Long[] books;
}
