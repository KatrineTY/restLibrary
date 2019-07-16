package com.spring.mvc.repository;

import com.github.javafaker.Faker;
import com.spring.mvc.component.Book;
import com.spring.mvc.dao.LibraryDao;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DummyDao implements LibraryDao {

    Faker faker = new Faker();
    List<Book> bookList = new ArrayList<Book>();

    public DummyDao() {
        for (int i = 1; i <= 25; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setGenre(faker.book().genre());
            book.setCount(Integer.parseInt(faker.numerify("##")));

            bookList.add(book);
        }
    }

    public List<Book> getBooks() {
        return bookList;
    }

    public void takeBook(int bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                book.setCount(book.getCount() - 1);
            }
        }
    }

}