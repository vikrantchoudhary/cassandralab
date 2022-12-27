package com.vikrant.org.microserviceslab2rest.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.org.microserviceslab2rest.models.Books;
import com.vikrant.org.microserviceslab2rest.services.BooksDAOService;


@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    BooksDAOService booksDAOService;

    @GetMapping("/all")
    public List<Books> getAll() {
        return booksDAOService.findAllCassandraJPA();
        //return null;
    }
    
    
}
