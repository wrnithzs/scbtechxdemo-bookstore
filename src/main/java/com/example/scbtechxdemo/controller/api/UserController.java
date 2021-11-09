package com.example.scbtechxdemo.controller.api;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.scbtechxdemo.controller.request.OrderRequest;
import com.example.scbtechxdemo.controller.request.UserRequest;
import com.example.scbtechxdemo.controller.response.OrderResponse;
import com.example.scbtechxdemo.controller.response.UserResponse;
import com.example.scbtechxdemo.exception.UserNotFoundException;
import com.example.scbtechxdemo.exception.ValidationException;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.service.OrderService;
import com.example.scbtechxdemo.service.UserService;

@RestController
@RequestMapping("/")
public class UserController {

	private UserService userService;
	private OrderService orderService;

	UserController(UserService userService, OrderService orderService) {
		this.userService = userService;
		this.orderService = orderService;
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody UserRequest userRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			bindingResult.getFieldErrors().stream().forEach(fieldError -> {
				throw new ValidationException(fieldError.getField() + ": " + fieldError.getDefaultMessage());
			});
		}
		return userService.createUser(userRequest);
	}

	@GetMapping("/users")
	public UserResponse getUser() {
		Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (username instanceof String) {
			User user = this.userService.findUserByUsername(username.toString());

			List<Long> books = this.orderService.findBookIdFromOrderByUserId(user.getId());

			return new UserResponse(user, books);
		}
		throw new UserNotFoundException();
	}

	@PostMapping("/users/orders")
	public OrderResponse createOrder(@Valid @RequestBody OrderRequest orderRequest) {
		Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (username instanceof String) {
			User user = this.userService.findUserByUsername(username.toString());

			return this.orderService.createOrder(orderRequest, user);
		}

		throw new UserNotFoundException();

	}

	@DeleteMapping("/users")
	public void deleteUserDetails() {
		Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (username instanceof String) {
			User user = this.userService.findUserByUsername(username.toString());

			this.orderService.deleteOrderByUserId(user.getId());
			this.userService.deleteUserByUserId(user.getId());

		} else {
			throw new UserNotFoundException();
		}

	}

}