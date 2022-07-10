package com.guyan.thinking.in.elastic.service.impl;

import com.guyan.thinking.in.elastic.model.Book;
import com.guyan.thinking.in.elastic.repository.BookRepository;
import com.guyan.thinking.in.elastic.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GuYan
 * @Time: 2022/7/10 14:00
 * @Description: TODO
 **/
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        Book entity = bookRepository.save(book);
        return entity;
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book findOne(String id) {
        return null;
    }

    @Override
    public Iterable<Book> findAll() {
        Iterable<Book> books = bookRepository.findAll();
        return books;
    }

    @Override
    public Page<Book> findByAuthorName(String authorName, PageRequest pageRequest) {
        Page<Book> byAuthor = bookRepository.findBookByAuthorName(authorName, pageRequest);
        return byAuthor;
    }

    @Override
    public List<Book> findByTitle(String name) {
        List<Book> bookByAuthorName = bookRepository.findBookByName(name);
        return bookByAuthorName;
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}
