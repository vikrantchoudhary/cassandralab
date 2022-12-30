package com.vikrant.org.microserviceslab2rest.services;


import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vikrant.org.microserviceslab2rest.Exceptions.UserNotFoundException;
import com.vikrant.org.microserviceslab2rest.controllers.versionings.PersonController;
import com.vikrant.org.microserviceslab2rest.models.Post;
import com.vikrant.org.microserviceslab2rest.models.User;
import com.vikrant.org.microserviceslab2rest.repositories.PostRepository;
import com.vikrant.org.microserviceslab2rest.repositories.UsersRepositry;

import jakarta.persistence.Entity;


@Component
public class UserDAOService {
    @Autowired
    private UsersRepositry usersRepositry;

    @Autowired
    private PostRepository postRepository;

    private static List<User> users = new ArrayList<>();
    private static int count = 0;
    static {
        users.add(new User(++count,"Vikrant",LocalDate.now().minusYears(30),45));
        users.add(new User(++count,"Adam",LocalDate.now().minusYears(20),55));
        users.add(new User(++count,"JOE",LocalDate.now().minusYears(10),33));
    }

    public List<User> getAll() {
        return users;
    }
    
    public List<User> findAllJPA() {
        return usersRepositry.findAll();
    }
    
    public MappingJacksonValue findAllWithFilter() {
        List<User> users = usersRepositry.findAll();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(users);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name","birth_date");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userBean", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    public void save(User user) {
        user.setId(++count);
        users.add(user);
        
    }
    public ResponseEntity<User> saveJPA(User user) {
        User savedUser = usersRepositry.save(user);
        URI locUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/jpa/user/{id}")
                    .buildAndExpand(savedUser.getId())
                    .toUri();
        return ResponseEntity.created(locUri).build();            

        
    }
    public ResponseEntity<Post> savePostforUser(int id,Post post) {
        Optional<User> user =  usersRepositry.findById(id);
        if (user.isEmpty()) 
            throw new UserNotFoundException("user not found with id: " + id);
        post.setUser(user.get());
        postRepository.save(post);
        URI locUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/jpa/user/{id}/posts")
                    .buildAndExpand(id)
                    .toUri();
        return ResponseEntity.created(locUri).build();
        
    }
    public User findOne(int id) {
        //List<User> users = usersRepositry.findAll();
        Predicate <? super User>  predicate  = user ->
        ((Integer)user.getId()).equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public User findOneJPA(int id) {
        Optional<User> user =  usersRepositry.findById(id);
        if (user.isEmpty()) 
            throw new UserNotFoundException("user not found with id: " + id);
        //EntityModel<User> userEntityModel = EntityModel.of(user.get());   
        //WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(new UserDAOService().getClass()).findAllJPA());
        //userEntityModel.add(link.withRel("all-users"));
        return user.get();
        
    }
    public List<Post> getAllPostforId(int id) {
        Optional<User> user =  usersRepositry.findById(id);
        if (user.isEmpty()) 
            throw new UserNotFoundException("user not found with id: " + id);
        return user.get().getPosts();
        
    }
    public void deleteUserbyIdJPA(int id) {
        Optional<User> user =  usersRepositry.findById(id);
        if (user.isEmpty()) 
            throw new UserNotFoundException("user not found with id: " + id);
        usersRepositry.deleteById(id);
    } 
    public void deleteUserbyId(int id) {
        Predicate <? super User>  predicate  = user ->
        ((Integer)user.getId()).equals(id);
        users.removeIf(predicate);
       
    } 
}
