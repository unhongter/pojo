package com.tedu;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class SpringRun {
    private static final String QUEUE="my-queue";
    @Bean
    public Queue query(){
        return new Queue(QUEUE);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRun.class,args);
    }
}
