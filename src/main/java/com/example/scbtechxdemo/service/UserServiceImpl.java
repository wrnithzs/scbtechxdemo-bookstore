package com.example.scbtechxdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.controller.request.UserRequest;
import com.example.scbtechxdemo.exception.UserDuplicateException;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements  UserService{
	@Autowired
	 UserRepository userRepository;

	public UserServiceImpl(UserRepository userReposirory) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(UserRequest userRequest) {
		User user = userRepository.findByUsername(userRequest.getUsername());
		if (user == null) {
			user = new User().setUsername(userRequest.getUsername())
			.setPassword(userRequest.getPassword())
			.setName(userRequest.getName())
			.setSurname(userRequest.getSurname())
			.setDateOfBirth(userRequest.getDateOfBirth());
			return userRepository.save(user);
		}
		throw new UserDuplicateException(userRequest.getUsername());
	}

}
