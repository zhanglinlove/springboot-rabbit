package com.example.rabbittest.mq;

import com.example.rabbittest.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderObject {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        User user = new User();
        user.setAddress("朝阳区");
        user.setAge(25);
        user.setPassword("123456");
        user.setUsername("张三");
        amqpTemplate.convertAndSend("object", user);
    }
}
