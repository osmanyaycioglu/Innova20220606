package com.innova.training.spring.person.rest;

import com.innova.training.spring.rest.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/query")
public class PersonQueryController {

    @GetMapping("/get/one")
    public Person getPerson(@RequestParam("pid")  Long personId){
        return null;
    }

    @GetMapping("/get/all")
    public List<Person> getPerson(){
        return null;
    }

}
