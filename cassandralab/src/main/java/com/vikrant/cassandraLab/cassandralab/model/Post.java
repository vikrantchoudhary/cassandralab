package com.vikrant.cassandraLab.cassandralab.model;


import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Table
public class Post {
    @PrimaryKey
    private UUID id;
    private String description;

    
    @JsonIgnore
    private User user;

    @Override
    public String toString() {
        return super.toString();
    }
}
