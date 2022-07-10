package com.guyan.thinking.in.elastic.service;

import com.guyan.thinking.in.elastic.model.Book;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Iterator;
import java.util.List;


@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Book book = new Book("平凡的世界", "路遥");
        book.setId(1L);
        bookService.save(book);
    }

    @Test
    void delete() {
        Book book = new Book("平凡的世界", "路遥");
        book.setId(1L);
        bookService.delete(book);
    }

    @Test
    void findOne() {
    }

    @Test
    void findAll() {
        Iterable<Book> books = bookService.findAll();
        Iterator<Book> bookIterator = books.iterator();
        while (bookIterator.hasNext()) {
            System.out.println(bookIterator.next());
        }
    }

    @Test
    void findByAuthor() {
        Page<Book> book = bookService.findByAuthorName("路遥", PageRequest.of(0, 10));
        System.out.println(book.getTotalPages());
    }

    @Test
    void findByTitle() {
        List<Book> books = bookService.findByTitle("平凡的世界");
        System.out.println(books.size());
    }
}