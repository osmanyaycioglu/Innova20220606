package com.innova.training.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    @Bean("hmworld")
    public HelloWorld helloWorldMethod(){
        return new HelloWorld();
    }

}
