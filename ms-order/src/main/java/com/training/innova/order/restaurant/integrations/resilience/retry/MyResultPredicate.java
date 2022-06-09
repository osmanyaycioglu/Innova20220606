package com.training.innova.order.restaurant.integrations.resilience.retry;

import com.training.innova.order.restaurant.integrations.models.PriceInfo;

import java.util.function.Predicate;

public class MyResultPredicate implements Predicate<PriceInfo> {
    @Override
    public boolean test(PriceInfo priceInfo) {
        System.out.println("MyResultPredicate çalıştı");
        if (priceInfo.getMenuId() == null) {
            return true;
        }
        return false;
    }
}
