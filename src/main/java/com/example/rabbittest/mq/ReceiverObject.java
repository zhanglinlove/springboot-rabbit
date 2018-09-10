package com.example.rabbittest.mq;

import com.example.rabbittest.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ReceiverObject {

    @RabbitHandler
    public void processor(User user) {
        System.out.println("receiver:" + user.toString());
    }
}
