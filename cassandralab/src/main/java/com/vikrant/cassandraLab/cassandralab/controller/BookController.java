package com.vikrant.cassandraLab.cassandralab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.cassandraLab.cassandralab.model.Books;
import com.vikrant.cassandraLab.cassandralab.repository.BookRepository;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/listBooks")
    public List<Books> listAll() {
        return bookRepository.findAll();
    }
    
}
