package com.example.demo.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "SAMPLE-TOPIC", groupId = "sample")
	public void listenGroupSample(String message) {
	    log.info("Received Message : " + message);
	}
	
}
