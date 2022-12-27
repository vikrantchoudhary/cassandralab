package com.vikrant.cassandraLab.cassandralab.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.vikrant.cassandraLab.cassandralab.model.Books;

public interface BookRepository extends CassandraRepository<Books,UUID>{
    @AllowFiltering
    List<Books> findByPublished(boolean published);
  
    List<Books> findByTitleContaining(String title);
}
