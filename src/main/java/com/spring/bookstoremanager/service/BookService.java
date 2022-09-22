package com.spring.bookstoremanager.service;

import com.spring.bookstoremanager.dto.BookDTO;
import com.spring.bookstoremanager.dto.MessageResponseDTO;
import com.spring.bookstoremanager.entity.Book;
import com.spring.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = Book.builder()
                .name(bookDTO.getName())
                .pages(bookDTO.getPages())
                .chapters(bookDTO.getChapters())
                .isbn(bookDTO.getIsbn())
                .publisherName(bookDTO.getPublisherName())
                .build();

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public List<Book> findAll(Book book) {
        List<Book> allBooks = bookRepository.findAll();
        return allBooks;
    }
}
