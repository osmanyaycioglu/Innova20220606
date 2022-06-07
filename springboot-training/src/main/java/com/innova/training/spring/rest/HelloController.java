package com.innova.training.spring.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    // @RequestMapping(value = "/world",method = RequestMethod.GET)
    @GetMapping("/world")
    public String hello() {
        return "Hello world GET";
    }

    @PostMapping("/world")
    public String hello2() {
        return "Hello world POST";
    }

    @DeleteMapping("/world")
    public String hello3() {
        return "Hello world DELETE";
    }

    @PutMapping("/world")
    public String hello4() {
        return "Hello world PUT";
    }

    @PatchMapping("/world")
    public String hello5() {
        return "Hello world PATCH";
    }

}
