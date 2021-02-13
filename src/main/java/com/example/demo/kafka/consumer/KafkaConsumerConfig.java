package com.example.demo.kafka.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.demo.dto.Customer;
import com.example.demo.kafka.producer.KafkaProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

	private final KafkaProperties kafkaProperties;

	@Bean
	public ConsumerFactory<String, Customer> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getGroupId());
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		// return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new
		// JsonDeserializer<>(Customer.class));

		ErrorHandlingDeserializer<String> headerErrorHandlingDeserializer = new ErrorHandlingDeserializer<>(
				new StringDeserializer());
		ErrorHandlingDeserializer<Customer> errorHandlingDeserializer = new ErrorHandlingDeserializer<>(
				new JsonDeserializer<>(Customer.class, objectMapper()));
		return new DefaultKafkaConsumerFactory<>(props, headerErrorHandlingDeserializer, errorHandlingDeserializer);
	}

	private ObjectMapper objectMapper() {
		return Jackson2ObjectMapperBuilder.json().visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
				.build();
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Customer> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Customer> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setErrorHandler(new KafkaConsumerErrorHandler());
		return factory;
	}
}