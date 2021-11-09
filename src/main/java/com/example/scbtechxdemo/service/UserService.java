package com.example.scbtechxdemo.service;


import com.example.scbtechxdemo.controller.request.UserRequest;
import com.example.scbtechxdemo.controller.response.UserResponse;
import com.example.scbtechxdemo.model.User;


public interface UserService {
	
	User createUser(UserRequest userRequest);
	User findUserByUsername(String username);
	void deleteUserByUserId(Long id);
}
