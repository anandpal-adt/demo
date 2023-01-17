package com.springboot.first.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.first.dao.BookRepository;
import com.springboot.first.entity.Book;

@Component
public class BookService {

 
	@Autowired
	private BookRepository bookRepository;

	//getAll books
	public List<Book> getAllBooks(){
		List<Book>	list=(List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book=null;
		try {
        book =this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return book;
	}

	//Adding book object
	public Book addBook(Book book) {
    Book b=this.bookRepository.save(book);
		return b;
	}
	
	//deleting book
	public void deleteBook(int id) {
       bookRepository.deleteById(id);
	}

	//update book
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
     bookRepository.save(book);
	}
}
