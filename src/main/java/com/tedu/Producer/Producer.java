package com.tedu.Producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private static final String QUEUE="my-queue";
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        String kb = "你好";
        rabbitTemplate.convertAndSend(QUEUE,kb);
    }
}
