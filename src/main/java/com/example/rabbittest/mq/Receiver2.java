package com.example.rabbittest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver2 {

    @RabbitHandler
    public void proccessor(String hello) {
        System.out.println("receiver2:" + hello);
    }
}
