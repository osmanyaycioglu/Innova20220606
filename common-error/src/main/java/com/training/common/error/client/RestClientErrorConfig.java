package com.training.common.error.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientErrorConfig {

    @Bean
    public FeignRestErrorDecoder feignRestErrorDecoder(){
        return new FeignRestErrorDecoder();
    }

}
