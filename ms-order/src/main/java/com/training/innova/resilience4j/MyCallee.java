package com.training.innova.resilience4j;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;

@Component
public class MyCallee {

    private int counter = 0;
    @CircuitBreaker(name = "xyzcs1")
    @Retry(name = "testretry", fallbackMethod = "callMeBack")
    public String callMe(String name) {
        counter++;
        if (counter % 7 == 0) {
            throw new IllegalArgumentException("olmadı " + name);
        }
        if (counter > 20) {
            try {
                Thread.sleep(1_000);
            } catch (Exception exception){
            }
            // throw new IllegalArgumentException("olmadı " + name);
        }
        return "Ok";

    }

    public String callMeBack(String name,
                             Throwable th) {
        System.out.println("FAAAAAAAAAAAALLLLLLLLLLLLLLLLLBBBBACCCCCCCCCKKK : " + name);
        return "Fallback " + name;
    }
}