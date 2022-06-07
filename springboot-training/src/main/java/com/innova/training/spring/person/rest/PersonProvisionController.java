package com.innova.training.spring.person.rest;

import com.innova.training.spring.person.models.Person;
import com.innova.training.spring.person.rest.mappers.IPersonMapper;
import com.innova.training.spring.rest.models.PersonRest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @PostMapping("/activate")
    public String activate(@Validated @RequestBody PersonRest personRest) {
        Person person = IPersonMapper.PERSON_MAPPER.toPerson(personRest);
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@RequestParam("personId") Long personId) {
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam("pid") Long personId) {
        return "OK";
    }

    @GetMapping("/reactivate")
    public String reeactivate(@RequestParam("pid") Long personId) {
        return "OK";
    }


}
