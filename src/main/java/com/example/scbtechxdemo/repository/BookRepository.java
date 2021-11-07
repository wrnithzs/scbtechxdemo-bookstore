package com.example.scbtechxdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scbtechxdemo.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
