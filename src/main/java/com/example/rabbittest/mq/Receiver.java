package com.example.rabbittest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void processor(String hello) {
        System.out.println("receiver:" + hello);
    }


}
