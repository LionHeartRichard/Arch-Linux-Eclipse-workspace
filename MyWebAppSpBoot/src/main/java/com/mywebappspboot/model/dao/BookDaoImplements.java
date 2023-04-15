package com.mywebappspboot.model.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mywebappspboot.model.Book;

@Repository
public class BookDaoImplements implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Book> getAllBooks() {
		Session session = sessionFactory.getCurrentSession();
		List<Book> books = session.createQuery("from book", Book.class).getResultList();
		return books;
	}

	@Override
	public void save(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(book);
	}

	@Override
	public Book getBookByIsbn(String isbn) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, isbn);
		return book;
	}

	@Override
	public void deleteBookByObject(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(book);
	}

}
