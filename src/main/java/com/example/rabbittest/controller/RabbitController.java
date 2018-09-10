package com.example.rabbittest.controller;

import com.example.rabbittest.mq.Receiver;
import com.example.rabbittest.mq.Sender;
import com.example.rabbittest.mq.SenderObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {

    @Autowired
    private SenderObject object;
    @Autowired
    private Sender sender;

    @GetMapping("/putInfo")
    public String rabbitPut(String name) {
        sender.send();
        return name;
    }

    @GetMapping("/objInfo")
    public String rabbitObject() {
        object.send();
        return "object success";
    }
}
