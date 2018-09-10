package com.example.rabbittest.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderFanout {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String message) {
        System.out.println("发送的数据:" + message);
        amqpTemplate.convertAndSend("fanout", "抛弃的数据", message);
    }
}
