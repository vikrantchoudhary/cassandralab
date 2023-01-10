package com.vikrant.cassandraLab.cassandralab.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



//@JsonIgnoreProperties({"id","fairyAge"})
//@JsonFilter("userBean")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table
public class User {

    @PrimaryKey
    private UUID id;

   
    private String name;
    @JsonProperty("birth_date")
    private LocalDate birth_date;
    //@JsonIgnore
    //@JsonProperty("Luck_age")
    private int fairy_age;

    
    @JsonIgnore
    private List<Post> posts;

    public User(UUID id, String name,LocalDate birth_date,int fairy_age){
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.fairy_age = fairy_age;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
