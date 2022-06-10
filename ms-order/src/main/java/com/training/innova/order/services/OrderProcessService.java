package com.training.innova.order.services;

import com.training.innova.order.rest.models.Order;
import com.training.innova.order.rest.models.OrderInfo;
import com.training.innova.order.restaurant.integrations.NotificaitonIntegrationService;
import com.training.innova.order.restaurant.integrations.RestaurantIntegrationService;
import com.training.innova.order.restaurant.integrations.models.MessageSend;
import com.training.innova.order.restaurant.integrations.models.PriceInfo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessService {

    @Autowired
    private RestaurantIntegrationService ris;

    @Autowired
    private NotificaitonIntegrationService notificaitonIntegrationService;

    public OrderInfo placeOrder(Order order){
        PriceInfo price = ris.getPrice(order);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(price.getMenuId());
        orderInfo.setStatus("Hazırlanıyor : " + price.getDesc());
        orderInfo.setPrice(price.getPrice());
        MessageSend messageSend = new MessageSend();
        messageSend.setMessage("Hazırlanıyor : " + price.getDesc());
        messageSend.setDest(order.getPhoneNumber());
        notificaitonIntegrationService.sendSMS(messageSend);
        return orderInfo;
    }


    public OrderInfo placeOrder2(Order order) {
        PriceInfo price = ris.getPriceFeign(order);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(price.getMenuId());
        orderInfo.setStatus("Hazırlanıyor 2 : " + price.getDesc());
        orderInfo.setPrice(price.getPrice());
        MessageSend messageSend = new MessageSend();
        messageSend.setMessage("Hazırlanıyor : " + price.getDesc());
        messageSend.setDest(order.getPhoneNumber());
        notificaitonIntegrationService.sendSMS(messageSend);
        return orderInfo;
    }
}
