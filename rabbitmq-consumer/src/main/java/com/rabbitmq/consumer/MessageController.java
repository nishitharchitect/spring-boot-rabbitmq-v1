package com.rabbitmq.consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    // http://localhost:8080/api/v1/publish?queue=taxi&message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("queue") String queue, @RequestParam("message") String message){
        producer.sendMessage(queue,message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

}
