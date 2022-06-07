package com.innova.training.spring.rest;

import com.innova.training.spring.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    // Field injection
    // @Autowired
    private HelloWorld hw;

    // Constructor Injection - Bunu kullan
    @Autowired
    public GreetingsController(@Qualifier("hmworld") HelloWorld hw) {
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

    // /greeting/hello?asd=???&jkl=???
    @GetMapping("/hello2")
    public String hello2(@RequestParam("asd") String name,
                         @RequestParam("jkl") String surname) {
        return hw.sayHello(name + " " + surname);
    }

    // /greeting/hello/osman?jkl=???
    @GetMapping("/hello3/{asd}")
    public String hello3(@PathVariable("asd") String name,
                         @RequestParam("jkl") String surname) {
        return hw.sayHello(name + " " + surname);
    }

    @GetMapping("/hello5")
    public String hello5(@RequestHeader("asd") String name,
                         @RequestHeader("jkl") String surname) {
        return hw.sayHello(name + " " + surname);
    }

    @PostMapping("/hello4")
    //@ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    public HelloResponse hello4(@RequestBody Person person) {
        System.out.println(person);
        return HelloResponse.create()
                            .setDesc("person alındı")
                            .setStatus(100);
    }


    @PostMapping("/hello6")
    public ResponseEntity<HelloResponse> hello6(@RequestBody Person person) {
        System.out.println(person);
        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                             .header("forword-me",
                                     "xyz")
                             .body(HelloResponse.create()
                                                .setDesc("person alındı")
                                                .setStatus(100));
    }


    @PostMapping("/hello7/{cmd}")
    public ResponseEntity<?> hello7(@PathVariable("cmd") String cmd,
                                    HttpServletRequest hsr) {
        switch (cmd) {
            case "add":
                String name = hsr.getParameter("name");
                String surname = hsr.getParameter("surname");
                String username = hsr.getHeader("username");
                return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                              .header("forword-me",
                                      "xyz")
                              .body(HelloResponse.create()
                                                 .setDesc("person alındı")
                                                 .setStatus(100));
            case "delete":
                String personId = hsr.getParameter("personId");
                return ResponseEntity.status(HttpStatus.OK)
                              .header("forword-me",
                                      "xyz")
                              .body("silindi");
        }

        return ResponseEntity.status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                             .header("forword-me",
                                     "xyz")
                             .body(HelloResponse.create()
                                                .setDesc("person alındı")
                                                .setStatus(100));
    }

}
