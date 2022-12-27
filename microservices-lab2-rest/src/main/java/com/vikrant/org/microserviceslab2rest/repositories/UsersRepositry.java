package com.vikrant.org.microserviceslab2rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikrant.org.microserviceslab2rest.models.User;



@Repository
public interface UsersRepositry extends JpaRepository<User,Integer> {
    
}
