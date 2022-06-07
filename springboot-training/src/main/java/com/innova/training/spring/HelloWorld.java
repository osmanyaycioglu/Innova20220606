package com.innova.training.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component("hworld")
//@Controller
//@Repository
//@Service
//@Configuration
//@Scope("singleton")
//@Scope("prototype")
public class HelloWorld {

    public String sayHello(String name){
        return "Hello " + name;
    }

}
