package com.vikrant.org.microserviceslab2rest.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorld {

    private String message;

    public HelloWorld(String message) {
        this.message = message;
    }

    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
