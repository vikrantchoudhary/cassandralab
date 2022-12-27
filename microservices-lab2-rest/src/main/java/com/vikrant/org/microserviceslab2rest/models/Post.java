package com.vikrant.org.microserviceslab2rest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Post {
    private int id;
    private String description;

    @Override
    public String toString() {
        return super.toString();
    }
}
