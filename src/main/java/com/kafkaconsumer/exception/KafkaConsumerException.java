package com.kafkaconsumer.exception;

public class KafkaConsumerException extends RuntimeException {

    public KafkaConsumerException(String message) {
        super(message);
    }
}
