package com.training.innova;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(name = "sms-queue", durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "notfication-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.DIRECT),
            key = "sms-notification"))
    // @SendTo("response-exchange/sms-reponse")
    public void consumeSMSEvent(final String str) {
        System.out.println("SMS Received Event : " + str);
        // return "SMS Sent to " + str.getDestination();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic-sms-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-topic",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "message.notify.sms.#"))
    @SendTo("sms-response-exchange/sms-response")
    public String consumeSMSTopicEvent(final MessageSend str) {
        System.out.println("SMS Received Event : " + str);
        return "SMS sent to " + str.getDest();
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic-mail-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-topic",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "message.notify.mail.#"))
    public void consumeMAILTopicEvent(final MessageSend str) {
        System.out.println("mail Received Event : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "topic-all-queue",
            durable = "true",
            autoDelete = "false"),
            exchange = @Exchange(name = "notfication-topic",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "message.#"))
    public void consumeAllTopicEvent(final MessageSend str) {
        System.out.println("All Received Event : " + str);
    }

}
