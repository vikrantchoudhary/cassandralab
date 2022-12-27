package com.vikrant.org.microserviceslab2rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vikrant.org.microserviceslab2rest.models.Books;
import com.vikrant.org.microserviceslab2rest.repositories.BooksRepository;


import java.util.List;

@Component
public class BooksDAOService {

    @Autowired
    BooksRepository booksRepository;

    public List<Books> findAllCassandraJPA() {
        return booksRepository.findAll();
    }
    
}
