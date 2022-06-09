package com.training.innova.order.restaurant.integrations.resilience.retry;

import java.util.function.Predicate;

public class ChooseToRetry implements Predicate<Throwable> {

    @Override
    public boolean test(Throwable throwable) {
        System.out.println("ChooseToRetry çalıştı");
        if (throwable instanceof IllegalArgumentException){
            return true;
        }
        return false;
    }
}
