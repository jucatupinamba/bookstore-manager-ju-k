package com.spring.bookstoremanager.controller;

import com.spring.bookstoremanager.dto.MessageResponseDTO;
import com.spring.bookstoremanager.entity.Book;
import com.spring.bookstoremanager.repository.BookRepository;
import com.spring.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        return bookService.create(book);
    }

}
