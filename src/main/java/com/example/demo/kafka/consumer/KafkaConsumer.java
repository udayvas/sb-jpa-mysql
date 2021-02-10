package com.example.demo.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.dto.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "${kafka.customer-topic-name}", groupId = "kafka.group-id")
	public void listenCustomerTopic(Customer message) {
	    log.info("Received Message : " + message.toString());
	}
	
}
