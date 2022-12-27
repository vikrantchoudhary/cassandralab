package com.vikrant.org.microserviceslab2rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Name {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
