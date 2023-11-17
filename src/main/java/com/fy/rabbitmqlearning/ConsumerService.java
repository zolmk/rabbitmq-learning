package com.fy.rabbitmqlearning;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author zhufeifei 2023/11/17
 **/

@Component
@RabbitListener(queues = "hi")
public class ConsumerService {

    @RabbitHandler
    public void handler(String messge) {
        System.out.println(messge);
    }


}
