package com.vikrant.cassandraLab.cassandralab.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table
public class Books {
    @PrimaryKey
    private UUID id;

    private String title;
    private String Author;
    private boolean published;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
