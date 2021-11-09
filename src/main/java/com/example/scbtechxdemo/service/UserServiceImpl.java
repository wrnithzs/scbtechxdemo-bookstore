package com.example.scbtechxdemo.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.scbtechxdemo.controller.request.UserRequest;
import com.example.scbtechxdemo.exception.UserDuplicateException;
import com.example.scbtechxdemo.exception.UserNotFoundException;
import com.example.scbtechxdemo.model.User;
import com.example.scbtechxdemo.repository.OrderRepository;
import com.example.scbtechxdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
			OrderRepository orderRepository) {

		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;

	}

	@Override
	public User createUser(UserRequest userRequest) {
		User user = userRepository.findByUsername(userRequest.getUsername());
		if (user == null) {
			user = new User().setUsername(userRequest.getUsername())
					.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword())).setName(userRequest.getName())
					.setRole(userRequest.getRole()).setSurname(userRequest.getSurname())
					.setDateOfBirth(userRequest.getDate_of_birth());

			return this.userRepository.save(user);
		}
		throw new UserDuplicateException(userRequest.getUsername());
	}

	@Override
	public User findUserByUsername(String username) {
		Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
		if (user.isPresent()) {
			return user.get();
		}
		 throw new UserNotFoundException(username);
	}

	@Override
	public void deleteUserByUserId(Long id) {
		userRepository.deleteById(id);
	}

}
