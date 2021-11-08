package com.example.scbtechxdemo.controller.api;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.scbtechxdemo.controller.request.UserRequest;
import com.example.scbtechxdemo.exception.ValidationException;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;

	 UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public User createUser(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream().forEach(fieldError -> {
				throw new ValidationException(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			});
		}
		return userService.createUser(userRequest);
	}

}