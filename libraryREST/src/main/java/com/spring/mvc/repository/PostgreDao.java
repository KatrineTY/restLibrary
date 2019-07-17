package com.spring.mvc.repository;

import com.spring.mvc.component.Book;
import com.spring.mvc.dao.LibraryDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgreDao implements LibraryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public PostgreDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getBooks() {
        Session session = sessionFactory.openSession();
        List<Book> books = session.createCriteria(Book.class).addOrder(Order.asc("id")).list();
        session.close();
        return books;
    }

    @Override
    public void takeBook(int bookId) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Book oldBook = (Book) session.get(Book.class, bookId);
        oldBook.setCount(oldBook.getCount() - 1);
        session.update(oldBook);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }

}
