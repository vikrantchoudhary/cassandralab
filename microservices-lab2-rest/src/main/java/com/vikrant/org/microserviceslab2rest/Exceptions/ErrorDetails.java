package com.vikrant.org.microserviceslab2rest.Exceptions;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetails {

    private LocalDateTime date;
    private String message;
    private String details;

    
}
