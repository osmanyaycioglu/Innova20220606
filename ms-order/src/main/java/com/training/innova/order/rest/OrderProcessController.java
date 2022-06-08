package com.training.innova.order.rest;

import com.training.innova.order.rest.models.Order;
import com.training.innova.order.rest.models.OrderInfo;
import com.training.innova.order.services.OrderProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/process/order/")
public class OrderProcessController {

    @Autowired
    private OrderProcessService orderProcessService;

    @PostMapping("/place")
    public OrderInfo placeOrder(@Validated @RequestBody Order order){
        return orderProcessService.placeOrder(order);
    }

}
