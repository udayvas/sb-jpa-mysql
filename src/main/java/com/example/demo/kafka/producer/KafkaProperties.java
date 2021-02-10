package com.example.demo.kafka.producer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="kafka")
@Data
public class KafkaProperties {
    private String bootstrapServers;
    private String groupId;
    private String customerTopicName;
    private String maxPollRecordsConfig;
    private String numberOfRetriesForProducer;
    private int producerTimeoutInMs;
    private int producerRetryBackoffInMs;
    private int concurrency;
    private boolean ssl = Boolean.FALSE;
    private String schemaVersionHeader;
    private String dc;
}
