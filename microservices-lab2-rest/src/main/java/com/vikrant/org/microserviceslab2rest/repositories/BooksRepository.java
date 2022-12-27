package com.vikrant.org.microserviceslab2rest.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.datastax.oss.driver.internal.core.type.codec.TimeUuidCodec;
import com.vikrant.org.microserviceslab2rest.models.Books;

@Repository
public interface BooksRepository extends CassandraRepository<Books,TimeUuidCodec>{
    
}
