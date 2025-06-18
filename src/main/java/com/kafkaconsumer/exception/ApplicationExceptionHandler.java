package com.kafkaconsumer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(KafkaConsumerException.class)
    public ResponseEntity<String> handleKafkaProducerException(KafkaConsumerException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }
}
