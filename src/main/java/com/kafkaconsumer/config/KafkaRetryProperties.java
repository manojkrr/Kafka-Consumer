package com.kafkaconsumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.kafka.consumer.retry")
@Data
public class KafkaRetryProperties {

    private int maxAttempts;
    private Backoff backoff = new Backoff();

    @Data
    public static class Backoff {
        private long initialInterval;
        private double multiplier;
        private long maxInterval;
    }
}
