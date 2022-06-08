package com.training.innova.order.services;

import com.training.innova.order.rest.models.Order;
import com.training.innova.order.rest.models.OrderInfo;
import com.training.innova.order.restaurant.integrations.RestaurantIntegrationService;
import com.training.innova.order.restaurant.integrations.models.PriceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessService {

    @Autowired
    private RestaurantIntegrationService ris;

    public OrderInfo placeOrder(Order order){
        PriceInfo price = ris.getPrice(order);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(price.getMenuId());
        orderInfo.setStatus("Hazırlanıyor : " + price.getDesc());
        orderInfo.setPrice(price.getPrice());
        return orderInfo;
    }


}
