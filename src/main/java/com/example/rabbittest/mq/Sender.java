package com.example.rabbittest.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String content = "hello" + new Date();
        System.out.println("send message:" + content);
        amqpTemplate.convertAndSend("hello", content);
    }
}
