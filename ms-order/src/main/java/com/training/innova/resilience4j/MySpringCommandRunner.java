package com.training.innova.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.retry.event.RetryOnRetryEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class MySpringCommandRunner implements CommandLineRunner {

    @Autowired
    private MyCallee myCallee;

    @Autowired
    private RetryRegistry retryRegistry;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    public void run(String... args) throws Exception {
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("xyzcs1");
        circuitBreaker.getEventPublisher()
                      .onSuccess(e -> System.out.println(
                              "Success Duration : " + e.getElapsedDuration()));
        CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
        for (int i = 0; i < 100; i++) {
            System.out.println("index-" + i);
            try {
                Thread.sleep(500);
                myCallee.callMe("index-" + i);
            } catch (Exception exp) {
                System.out.println("index-" + i + " Error geldi : " + exp.getClass()
                                                                         .getName());
            }
            System.out.println("index-" + i + " state : " + circuitBreaker.getState() + " np : "
                                       + metrics.getNumberOfNotPermittedCalls()
                                       + " s : "
                                       + metrics.getNumberOfSuccessfulCalls()
                                       + " f : "
                                       + metrics.getNumberOfFailedCalls()
                                       + " slow : "
                                       + metrics.getNumberOfSlowCalls()
            );
        }
    }


    public void run2(String... args) throws Exception {
        Retry testretry = retryRegistry.retry("testretry");
        Retry.EventPublisher eventPublisher = testretry.getEventPublisher();
        eventPublisher.onRetry(e -> System.out.println(
                "Retry : " + e.getNumberOfRetryAttempts() + " wait : " + e.getWaitInterval()));
        for (int i = 0; i < 30; i++) {
            System.out.println("index-" + i);
            try {
                myCallee.callMe("index-" + i);
            } catch (Exception exp) {
                System.out.println("index-" + i + " Error geldi : " + exp.getClass()
                                                                         .getName());
            }
            System.out.println("index-" + i + " f : " + testretry.getMetrics()
                                                                 .getNumberOfFailedCallsWithoutRetryAttempt() + " rf : "
                                       + testretry.getMetrics()
                                                  .getNumberOfFailedCallsWithRetryAttempt()
                                       + " s : "
                                       + testretry.getMetrics()
                                                  .getNumberOfSuccessfulCallsWithoutRetryAttempt()
                                       + " sr : "
                                       + testretry.getMetrics()
                                                  .getNumberOfSuccessfulCallsWithRetryAttempt()

            );
        }
    }

}
