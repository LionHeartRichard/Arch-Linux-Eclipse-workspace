package com.mywebappspboot.model.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mywebappspboot.model.Book;

@Component
public interface BookDao {

	public List<Book> getAllBooks();

	public void save(Book book);

	public void update(Book book);

	public Book getBookByIsbn(String isbn);

	public void deleteBookByObject(Book book);

}
