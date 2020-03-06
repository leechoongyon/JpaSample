package com.example.controller;

import com.example.model.Book;
import com.example.service.BookRestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {

    private final BookRestService bookRestService;

    public BookRestController(BookRestService bookRestService) {
        this.bookRestService = bookRestService;
    }


    @GetMapping(value = "/rest/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBook() {
        return bookRestService.getRestBook();
    }



}