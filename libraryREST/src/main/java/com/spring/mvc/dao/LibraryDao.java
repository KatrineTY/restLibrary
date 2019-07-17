package com.spring.mvc.dao;

import com.spring.mvc.component.Book;

import java.util.List;

public interface LibraryDao {
    List<Book> getBooks();

    void takeBook(int bookId);

    void addBook(Book book);

}
