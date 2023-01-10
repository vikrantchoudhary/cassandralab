package com.vikrant.cassandraLab.cassandralab.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.vikrant.cassandraLab.cassandralab.model.User;

public interface UserRepository extends CassandraRepository<User,UUID>{
    
}
