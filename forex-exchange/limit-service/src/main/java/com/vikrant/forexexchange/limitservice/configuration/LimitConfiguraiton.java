package com.vikrant.forexexchange.limitservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;



@Configuration
@ConfigurationProperties(prefix = "limits-service")
@Setter
@Getter
public class LimitConfiguraiton {
    private int maximum;
    private int minimum;
    
    public LimitConfiguraiton(int maximum, int minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }
    public LimitConfiguraiton() {
        this.maximum=Integer.MAX_VALUE;
        this.minimum = Integer.MIN_VALUE;
    }
    
    
}
