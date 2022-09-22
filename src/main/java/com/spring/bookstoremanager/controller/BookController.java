package com.spring.bookstoremanager.controller;

import com.spring.bookstoremanager.dto.BookDTO;
import com.spring.bookstoremanager.dto.MessageResponseDTO;
import com.spring.bookstoremanager.entity.Book;
import com.spring.bookstoremanager.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping
    public ResponseEntity<List<Book>> allBooks(@RequestBody Book book){
        List<Book> allboks = bookService.findAll(book);
        return ResponseEntity.ok(allboks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        Book bookId = bookService.findById(id);
        if(bookId == null){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(book, bookId, "id");
        return ResponseEntity.ok(bookService.save(bookId));
    }

}
