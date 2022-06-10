package com.training.innova.order.restaurant.integrations;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("X-Origin",
                        "restaurant.subdomain.order.order");
    }
}
