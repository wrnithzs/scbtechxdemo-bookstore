package com.example.scbtechxdemo.service;

import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.controller.request.UserRequest;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	private UserRepository userRepository;

	UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
		
	}

	@Override
	public User createUser(UserRequest userRequest) {
		User user = userRepository.findByUsername(userRequest.getUsername());
		if (user == null) {
			user = new User().setUsername(userRequest.getUsername())
					.setPassword(userRequest.getPassword());

			return userRepository.save(user);
		}
		return null;
	}
	
	
	
}
