package com.vikrant.org.microserviceslab2rest.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.vikrant.org.microserviceslab2rest.models.User;
import com.vikrant.org.microserviceslab2rest.repositories.UsersRepositry;


@Component
public class UserDAOService {
    @Autowired
    private UsersRepositry usersRepositry;

    private static List<User> users = new ArrayList<>();
    private static int count = 0;
    static {
        users.add(new User(++count,"Vikrant",LocalDate.now().minusYears(30),45));
        users.add(new User(++count,"Adam",LocalDate.now().minusYears(20),55));
        users.add(new User(++count,"JOE",LocalDate.now().minusYears(10),33));
    }

    public List<User> findAll() {
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
    public void saveJPA(User user) {
        usersRepositry.save(user);
    }
    public User findOne(int id) {
        //List<User> users = usersRepositry.findAll();
        Predicate <? super User>  predicate  = user ->
        ((Integer)user.getId()).equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public Optional<User> findOneJPA(int id) {
        return usersRepositry.findById(id);
        
    }
    public void deleteUserbyIdJPA(int id) {
        Optional<User> useroptional = findOneJPA(id);
        if (useroptional.isPresent() ) {
            usersRepositry.delete(useroptional.get());
        }
        
    } 
    public void deleteUserbyId(int id) {
        Predicate <? super User>  predicate  = user ->
        ((Integer)user.getId()).equals(id);
        users.removeIf(predicate);
       
    } 
}
