package com.training.innova.order.restaurant.integrations;

import com.training.innova.order.restaurant.integrations.models.MessageSend;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificaitonIntegrationService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendSMS(MessageSend messageSend) {
        rabbitTemplate.convertAndSend("notfication-topic",
                                      "message.notify.sms.istanbul.27age",
                                      messageSend);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(name = "sms-repsonse-queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "sms-response-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.DIRECT),
            key = "sms-response"))
    public void consumeSMSEvent(final String str) {
        System.out.println("SMS Received Event : " + str);
    }

}
