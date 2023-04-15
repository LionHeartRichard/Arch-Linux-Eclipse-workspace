package com.mywebappspboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mywebappspboot.controller.service.BookService;
import com.mywebappspboot.model.Book;

@RestController
@RequestMapping("/api")
public class MyMainController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

}
