package com.kafkaconsumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
@EnableRetry
@EnableConfigurationProperties(KafkaRetryProperties.class)
public class KafkaConfig {

    @Value("${spring.kafka.topic.name}")
    private String kafkaTopicName;

    @Bean
    public String kafkaTopicName() {
        return kafkaTopicName;
    }

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        // Exponential backoff policy
        ExponentialBackOffPolicy backoffPolicy = new ExponentialBackOffPolicy();
        backoffPolicy.setInitialInterval(1000); // Initial interval in milliseconds
        backoffPolicy.setMultiplier(2.0); // Exponential multiplier
        backoffPolicy.setMaxInterval(10000); // Maximum interval in milliseconds

        retryTemplate.setBackOffPolicy(backoffPolicy);

        // Retry policy
        RetryPolicy retryPolicy = new SimpleRetryPolicy(3); // Retry up to 3 times
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }

}
