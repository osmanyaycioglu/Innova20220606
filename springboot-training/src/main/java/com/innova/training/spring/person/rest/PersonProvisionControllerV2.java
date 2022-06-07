package com.innova.training.spring.person.rest;

import com.innova.training.spring.rest.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionControllerV2 {

    @PutMapping
    public String activate(Person person){
        return "OK";
    }

    @DeleteMapping
    public String deactivate(@RequestParam("pid") Long personId){
        return "OK";
    }

    @PostMapping("/suspend")
    public String suspend(@RequestParam("pid") Long personId){
        return "OK";
    }

    @PostMapping("/reactivate")
    public String reeactivate(@RequestParam("pid") Long personId){
        return "OK";
    }

}
