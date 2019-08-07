package com.tedu.Consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static final String QUEUE="my-queue";
    @RabbitListener(queues = QUEUE)
    public void recievie(String message){
        System.out.println(123);
        System.out.println(message);
    }
}
