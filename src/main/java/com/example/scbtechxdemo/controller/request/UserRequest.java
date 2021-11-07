package com.example.scbtechxdemo.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

	private String username;
	private String password;
	private String name;
	private String surname;
	private String dateOfBirth;
}
