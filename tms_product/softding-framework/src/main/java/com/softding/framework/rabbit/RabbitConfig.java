package com.softding.framework.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZhangCun
 * @Date: 2020-03-18 13:02
 * @describe：
 */
//@Configuration
public class RabbitConfig {
    //队列 起名：TestDirectQueue
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    final static String message = "topic.message";
    final static String messages = "topic.messages";

    //创建队列，名称：message
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitConfig.message);
    }
    //创建队列，名称：messages
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitConfig.messages);
    }

    //创建交换机：exchange
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    //队列交换机绑定，并设置路由
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    //队列交换机绑定，并设置路由
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
