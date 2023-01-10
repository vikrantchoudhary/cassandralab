package com.vikrant.org.microserviceslab2rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikrant.org.microserviceslab2rest.models.Post;



@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    
}
