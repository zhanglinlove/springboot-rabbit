package com.example.rabbittest.controller;

import com.example.rabbittest.mq.Receiver;
import com.example.rabbittest.mq.Sender;
import com.example.rabbittest.mq.SenderFanout;
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
    @Autowired
    private SenderFanout senderFanout;

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

    @GetMapping("/broadInfo")
    public String broadInfo() {
        senderFanout.send("广播信息发送");
        return "broadcast info";
    }

    @GetMapping("/topic1")
    public String topicInfo() {
        sender.send2();
        return "topic1 success";
    }

    @GetMapping("/topic2")
    public String topicInfo2() {
        sender.send3();
        return "topic2 success";
    }

    @GetMapping("/topic3")
    public String topicInfo3() {
        sender.send4();
        return "topic3 success";
    }

    @GetMapping("/test")
    public String testInfo() {
        sender.send5();
        return "test success";
    }
}
