package com.springboot.first.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.first.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	public Book findById(int id);
}
