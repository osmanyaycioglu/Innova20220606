package com.innova.training.spring.person.rest;

import com.innova.training.spring.rest.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonManagementController {

    @PostMapping("/update")
    public String update(@RequestBody Person person){
        return "OK";
    }

}
