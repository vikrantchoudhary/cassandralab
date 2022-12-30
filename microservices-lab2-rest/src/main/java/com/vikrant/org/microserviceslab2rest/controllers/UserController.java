package com.vikrant.org.microserviceslab2rest.controllers;

import java.net.URI;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vikrant.org.microserviceslab2rest.Exceptions.UserNotFoundException;
import com.vikrant.org.microserviceslab2rest.controllers.versionings.PersonController;
import com.vikrant.org.microserviceslab2rest.models.Post;
import com.vikrant.org.microserviceslab2rest.models.User;
import com.vikrant.org.microserviceslab2rest.services.UserDAOService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserDAOService userDAOService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userDAOService.getAll();
        //return userDAOService.findAllWithFilter();
    }
    @GetMapping("/jpa/users")
    public List<User> getAllJPA() {
        return userDAOService.findAllJPA();
        //return userDAOService.findAllWithFilter();
    }
    @GetMapping("/filter/users")
    public MappingJacksonValue getAllfilter() {
        return userDAOService.findAllWithFilter();
    }
    @GetMapping("/user/{id}")
    public EntityModel<User> getUserbyId(@PathVariable int id) {
        User user = userDAOService.findOne(id);
        if (user == null) throw new UserNotFoundException("User not found for id " + id);
        EntityModel<User>  entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn(this.getClass()).getAll());
        entityModel.add(link.withRel("all-users"));
        link = WebMvcLinkBuilder.linkTo(
            WebMvcLinkBuilder.methodOn((new PersonController()).getClass()).getPersonV2());
        entityModel.add(link.withRel("dummy"));
        return entityModel;
        
    }
    @GetMapping("/jpa/user/{id}/posts")
    public List<Post> getUserPostById(@PathVariable int id) {
        return userDAOService.getAllPostforId(id);
    }
    @GetMapping("/jpa/user/{id}")
    public User getUserbyIdJPA(@PathVariable int id) {
        return userDAOService.findOneJPA(id);
        
    }
    @DeleteMapping("/user/{id}")
    public void deleteUserbyId(@PathVariable int id) {
        userDAOService.deleteUserbyId(id);
        
    }
    @DeleteMapping("/jpa/user/{id}")
    public void deleteUserbyIdJPA(@PathVariable int id) {
        userDAOService.deleteUserbyIdJPA(id);
        
    }

    @PostMapping("/userCreate")
    public ResponseEntity<User> createUser(@Valid @RequestBody  User user) {
       userDAOService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/{id}").
        buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @PostMapping("/jpa/userCreate")
    public ResponseEntity<User> createUserJPA(@Valid @RequestBody  User user) {
       return userDAOService.saveJPA(user);
    }
    @PostMapping("/jpa/createPost/{id}")
    public ResponseEntity<Post> createPostJPA(@PathVariable int id,@Valid @RequestBody  Post post) {
       return userDAOService.savePostforUser(id, post);
    }
    
}
