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

    public void send2() {
        String mess = "I am message topic1";
        amqpTemplate.convertAndSend("topicExchange", "topic.1", mess);
    }

    public void send3() {
        String  mess = "I am message topic2";
        amqpTemplate.convertAndSend("topicExchange", "topic.message1", mess);
    }

    public void send4() {
        String mess = "I am message topic3";
        amqpTemplate.convertAndSend("topicExchange", "topic.message2", mess);
    }

    public void send5() {
        String mess = "test send durable";
        amqpTemplate.convertAndSend("test", mess);
    }
}
