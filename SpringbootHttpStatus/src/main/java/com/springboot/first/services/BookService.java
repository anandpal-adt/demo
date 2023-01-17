package com.springboot.first.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.first.entity.Book;

@Component
public class BookService {

	
	private static List<Book> list=new ArrayList<>();
	
	static {
		list.add(new Book( 12,"Let us C","Anand rajput"));
		list.add(new Book( 13,"Let us D","Anand rajput"));
		list.add(new Book( 14,"Let us E","Anand rajput"));
		list.add(new Book( 15,"Let us F","Anand rajput"));
	}
	
	//getAll books
	public List<Book> getAllBooks(){
		return list;
	}
	
	//get single book by id
	public Book getBookById(int id) {
		Book book=null;
		try {
	     book=list.stream().filter(o->o.getId()==id).findFirst().get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return book;
	}

	//Adding book object
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}
	
	//deleting book
	public void deleteBook(int id) {
		list=list.stream().filter(book->(book.getId()!=id)).collect(Collectors.toList());
   //	list.remove(id);
	}

	//update book
	public void updateBook(Book book, int bookId) {
        list=list.stream().map(b->{
        	if(b.getId()==bookId) {
        		b.setAuthor(book.getAuthor());
        		b.setTitle(book.getTitle());
        	}
        	return b;
        	}).collect(Collectors.toList());
	}
}
