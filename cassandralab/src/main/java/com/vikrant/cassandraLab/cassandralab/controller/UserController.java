package com.vikrant.cassandraLab.cassandralab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.cassandraLab.cassandralab.model.User;
import com.vikrant.cassandraLab.cassandralab.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-users")
    public List<User> getUsers() {
        return userService.findAllUsers();
    }
    
}
