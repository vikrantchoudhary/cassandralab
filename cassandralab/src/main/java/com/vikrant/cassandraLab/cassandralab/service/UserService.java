package com.vikrant.cassandraLab.cassandralab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikrant.cassandraLab.cassandralab.model.User;
import com.vikrant.cassandraLab.cassandralab.repository.PostRepository;
import com.vikrant.cassandraLab.cassandralab.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
