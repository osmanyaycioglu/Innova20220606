package com.innova.training.spring.person.rest;

import com.innova.training.spring.rest.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/v1/department/management")
public class DepartmentController {

    @PostMapping("/add")
    public String update(@RequestParam("dep") String department) {
        return "OK";
    }

}
