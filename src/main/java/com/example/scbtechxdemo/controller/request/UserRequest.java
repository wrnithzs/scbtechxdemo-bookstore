package com.example.scbtechxdemo.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
	@NotBlank
	@Size(min = 1, max = 100)
	private String username;
	@NotBlank
	@Length(min = 6, message = "The field must be at least {min} characters")
	private String password;
	private String name;
	private String surname;
	private String dateOfBirth;
}
