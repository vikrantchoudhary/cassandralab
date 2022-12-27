package com.vikrant.org.microserviceslab2rest.models;

import java.time.LocalDate;

//import com.fasterxml.jackson.annotation.JsonFilter;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@JsonIgnoreProperties({"id","fairyAge"})
//@JsonFilter("userBean")
@Entity(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Size(min = 2, message = "Name must be atleast of size 2")
    private String name;
    @Past (message = "birthday should be past date ")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
    //@JsonIgnore
    //@JsonProperty("Luck_age")
    private int fairyAge;

    @Override
    public String toString() {
        return super.toString();
    }

}
