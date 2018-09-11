package com.example.rabbittest.common;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }

    @Bean
    public Queue firstBroadcastQueue() {
        return new Queue("firstBroadcastQueue");
    }

    @Bean
    public Queue secondBroadcastQueue() {
        return new Queue("secondBroadcastQueue");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout");
    }

    @Bean
    public Binding fistBinding() {
        return BindingBuilder.bind(firstBroadcastQueue()).to(fanoutExchange());
    }

    @Bean
    public Binding secondBinding() {
        return BindingBuilder.bind(secondBroadcastQueue()).to(fanoutExchange());
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Queue queueMessage1() {
        return new Queue("topic.message1");
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue("topic.message2");
    }

    @Bean
    public Binding bindQueuMessage1(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message1");
    }

    @Bean
    public Binding bindQueueMessage2(Queue queueMessage2, TopicExchange exchange) {

        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }
}
