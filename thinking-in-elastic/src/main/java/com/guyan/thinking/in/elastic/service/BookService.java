package com.guyan.thinking.in.elastic.service;

import com.guyan.thinking.in.elastic.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService {
    Book save(Book book);

    void delete(Book book);

    Book findOne(String id);

    Iterable<Book> findAll();

    Page<Book> findByAuthorName(String authorName, PageRequest pageRequest);

    List<Book> findByTitle(String title);
}
