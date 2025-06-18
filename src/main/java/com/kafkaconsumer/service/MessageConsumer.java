package com.kafkaconsumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    @Retryable(
            maxAttemptsExpression = "#{${app.kafka.consumer.retry.max-attempts}}",
            backoff = @Backoff(
                    delayExpression = "#{${app.kafka.consumer.retry.backoff.initial-interval}}",
                    multiplierExpression = "#{${app.kafka.consumer.retry.backoff.multiplier}}",
                    maxDelayExpression = "#{${app.kafka.consumer.retry.backoff.max-interval}}"
            )
    )
    public void consume(String message) {
        System.out.println("Received message: " + message);
        processMessage(message);
    }

    private void processMessage(String message) {
        if (message.contains("fail")) {
            throw new RuntimeException("Simulated failure during processing");
        }
        System.out.println("Processed message: " + message);
    }
}
