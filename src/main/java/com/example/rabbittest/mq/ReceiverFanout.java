package com.example.rabbittest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverFanout {

    @RabbitListener(queues = "firstBroadcastQueue")
    @RabbitHandler
    public void processor1(String message) {
        System.out.println("fanout receiver1:" + message);
    }

    @RabbitListener(queues = "secondBroadcastQueue")
    @RabbitHandler
    public void processor2(String message) {
        System.out.println("fanout receiver2:" + message);
    }
}
