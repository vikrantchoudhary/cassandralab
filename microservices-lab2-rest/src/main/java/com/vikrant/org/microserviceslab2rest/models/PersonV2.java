package com.vikrant.org.microserviceslab2rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PersonV2 {
    private Name name;
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
