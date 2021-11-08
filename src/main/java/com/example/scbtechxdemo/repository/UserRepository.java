package com.example.scbtechxdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scbtechxdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
