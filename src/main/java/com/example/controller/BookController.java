package com.example.controller;

import com.example.repository.BookRepository;
import com.example.service.BookService;
import com.example.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {
    private final BookService bookService;

    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBook();
    }

    @RequestMapping("/{id}")
    @PutMapping
    public Book updateBook(@PathVariable long id, @RequestParam double price) {
        Book book = bookService.getBook();
        log.info("book : {}", book);
        book.setPrice(price);
        return book;
    }

    @RequestMapping
    @PostMapping
    public Book insertBook(@RequestBody Book book) {
        Book resultBook = bookRepository.save(book);
        return resultBook;
    }

    @RequestMapping("/nativeQuery")
    @PostMapping
    public List<Book> getBookWithNativeQuery(@RequestParam double price) {
        return bookRepository.findByNativeQuery(price);
    }

}