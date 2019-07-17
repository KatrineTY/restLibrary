package com.spring.mvc.controller;

import com.spring.mvc.component.Book;
import com.spring.mvc.dao.LibraryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookTableController {

    @Autowired
    private LibraryDao libraryDao;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return libraryDao.getBooks();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public Map<String, Boolean> takeBook(@PathVariable int id) {
        libraryDao.takeBook(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        libraryDao.addBook(book);
    }

}