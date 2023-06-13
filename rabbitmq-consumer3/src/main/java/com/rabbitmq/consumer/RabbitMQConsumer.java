package com.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "hotel")
    public void receiveMessage(String message){
    	System.out.println("message received hotel  "+message);
        LOGGER.info(String.format("Received message hotel -> %s", message));
    }

}
