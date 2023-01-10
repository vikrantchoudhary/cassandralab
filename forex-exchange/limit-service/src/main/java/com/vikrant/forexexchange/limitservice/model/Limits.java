package com.vikrant.forexexchange.limitservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Limits {
    
    private int maximum;
    private int minimum;

}
