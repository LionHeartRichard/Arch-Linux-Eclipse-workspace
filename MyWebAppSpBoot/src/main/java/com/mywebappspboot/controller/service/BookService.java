package com.mywebappspboot.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywebappspboot.model.Book;

@Service
public interface BookService {

	public List<Book> getAllBooks();

	public void save(Book book);

	public void update(Book book);

	public Book getBookByIsbn(String isbn);

	public void deleteBookByObject(Book book);

}
