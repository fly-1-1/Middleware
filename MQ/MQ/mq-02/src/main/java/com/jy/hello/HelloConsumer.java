package com.jy.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello" ,durable = "true",autoDelete = "false"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("Received <" + message + ">");
    }

}
