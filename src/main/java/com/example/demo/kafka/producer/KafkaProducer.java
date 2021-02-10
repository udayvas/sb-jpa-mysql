package com.example.demo.kafka.producer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.demo.dto.Customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
@ConditionalOnProperty(name = "kafka.producer-enabled", havingValue = "true")
public class KafkaProducer {

	private final KafkaProperties kafkaProperties;
	private final KafkaTemplate<String, Customer> kafkaTemplate;

	public void sendMessage(Customer message) {
		ListenableFuture<SendResult<String, Customer>> future = kafkaTemplate.send(kafkaProperties.getCustomerTopicName(), message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, Customer>>() {

			@Override
			public void onSuccess(SendResult<String, Customer> result) {
				log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
			}
		});
	}
}
