package com.fy.rabbitmqlearning.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhufeifei 2023/11/17
 **/

@Configuration
public class RabbitMQConfig {

    @Bean
    Queue queue() {
        Queue q = new Queue("hi");

        return q;
    }

}
