package com.example.demo.web.controller;

import com.example.demo.web.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    public Person index() {
        return new Person((long) 1, "Nice to meet you");
    }


    @RequestMapping("/hello")
    public Person hello() {
        return new Person((long) 2, "POC");
    }


}

