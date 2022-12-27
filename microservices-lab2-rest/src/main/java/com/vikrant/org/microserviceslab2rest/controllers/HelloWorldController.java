package com.vikrant.org.microserviceslab2rest.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vikrant.org.microserviceslab2rest.models.HelloWorld;


@RestController
public class HelloWorldController {

    @Autowired
    MessageSource messageSource;

    @GetMapping("/hello")
    //@RequestMapping(method = RequestMethod.GET,path = "/hello1")
    public String hello() {
        System.out.println("hello");
        return "Hello world";

    }

    @GetMapping("hello2")
    public HelloWorld hello2() {
        return new HelloWorld("HelloWorld");
    }

    @GetMapping("hello3/{message}")
    public HelloWorld hello3(@PathVariable String message) {
        return new HelloWorld(message );
    }
    @GetMapping("hello4/{message}")
    public String hello4(@PathVariable String message) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
        //return new HelloWorld(message );
    }

    @GetMapping("hello3/{message}/to/{message2}")
    public HelloWorld hello31(@PathVariable String message, @PathVariable String message2) {
        return new HelloWorld(message + " to " + message2);
    }
}
