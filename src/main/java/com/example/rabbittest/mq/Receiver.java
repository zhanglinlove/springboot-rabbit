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

    @RabbitListener(queues = "topic.message1")
    @RabbitHandler
    public void processor2(String hello) {
        System.out.println("receiver2:" + hello);
    }

    @RabbitListener(queues = "topic.message2")
    @RabbitHandler
    public void processor3(String hello) {
        System.out.println("receiver3:" + hello);
    }
}
