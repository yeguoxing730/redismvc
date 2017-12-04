package com.springapp.service;

import com.springapp.entity.Book;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: uc203808
 * Date: 12/4/17
 * Time: 12:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class BookAppService {
    Book book = new Book();
    @CachePut(value = "mycache")
    public Book setBook(String name) {
        System.out.println("Executing setBook method..."+name);
        book.setName(name);
        return book;
    }
    @Cacheable(value = "mycache")
    public Book getBook() {
        System.out.println("Executing getBook method...");
        book.setName("Mahabharat");
        return book;
    }
}
