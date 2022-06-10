package com.training.innova.order.health;

import com.training.innova.order.rest.models.Order;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyHealth implements HealthIndicator {

    @Override
    public Health health() {
        Order order = new Order();
        order.setMeals(List.of("osman",
                               "mehmet"));
        order.setPhoneNumber("32893223");
        order.setName("haluk");
        order.setSurname("levent");
        return Health.status(Status.UP)
                     .withDetail("desc_test",
                                 order)
                     .build();
    }

}
