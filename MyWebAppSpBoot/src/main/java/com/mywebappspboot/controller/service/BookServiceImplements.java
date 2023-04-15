package com.mywebappspboot.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywebappspboot.model.Book;
import com.mywebappspboot.model.dao.BookDao;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImplements implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}

	@Override
	@Transactional
	public void update(Book book) {
		bookDao.update(book);
	}

	@Override
	@Transactional
	public Book getBookByIsbn(String isbn) {
		return bookDao.getBookByIsbn(isbn);
	}

	@Override
	@Transactional
	public void deleteBookByObject(Book book) {
		bookDao.deleteBookByObject(book);
	}

}
