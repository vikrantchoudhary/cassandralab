package com.vikrant.forexexchange.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.forexexchange.limitservice.configuration.LimitConfiguraiton;
import com.vikrant.forexexchange.limitservice.model.Limits;

@RestController
public class LimitsController {
    
    @Autowired
    private LimitConfiguraiton limitConfiguraiton;

    @GetMapping("/limit")
    public Limits getlimit() {
        return new Limits(1000,1);
    }
    @GetMapping("/limit/config")
    public LimitConfiguraiton getlimitConfig() {
        return new LimitConfiguraiton(limitConfiguraiton.getMaximum(),limitConfiguraiton.getMinimum());
    }
}
