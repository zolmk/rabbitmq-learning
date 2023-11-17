package com.fy.rabbitmqlearning;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhufeifei 2023/11/17
 **/
@Component
public class ProductService implements ApplicationRunner {
    @Autowired
    private AmqpTemplate amqpTemplate;
    private static final ScheduledExecutorService EXECUTOR = Executors.newSingleThreadScheduledExecutor();
    @Override
    public void run(ApplicationArguments args) throws Exception {
        EXECUTOR.schedule(new Task(), 1, TimeUnit.SECONDS);
    }


    private class Task implements Runnable {
        @Override
        public void run() {
            amqpTemplate.convertAndSend("hi", "朱非非");
            EXECUTOR.schedule(this, 1, TimeUnit.SECONDS);
        }
    }
}