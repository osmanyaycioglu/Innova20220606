package com.innova.training.spring.rest;

import com.innova.training.spring.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    // Field injection
    // @Autowired
    private HelloWorld hw;

    // Constructor Injection - Bunu kullan
    @Autowired
    public GreetingsController(@Qualifier("hmworld")  HelloWorld hw) {
        this.hw = hw;
    }

    // Method Injection
    // @Autowired
    public void xyz(HelloWorld hw) {
        this.hw = hw;
    }

    // /greeting/hello/???/???
    @GetMapping("/hello/{asd}/{jkl}")
    public String hello(@PathVariable("asd") String name,
                        @PathVariable("jkl") String surname) {
        return hw.sayHello(name + " " + surname);
    }

    // /greetşng/hello?asd=???&jkl=???
    @GetMapping("/hello2")
    public String hello2(@RequestParam("asd") String name,
                         @RequestParam("jkl") String surname) {
        return hw.sayHello(name + " " + surname);
    }

    // /greetşng/hello/osman?jkl=???
    @GetMapping("/hello3/{asd}")
    public String hello3(@PathVariable("asd") String name,
                         @RequestParam("jkl") String surname) {
        return hw.sayHello(name + " " + surname);
    }

}
