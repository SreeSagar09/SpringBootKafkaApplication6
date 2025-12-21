package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

@Configuration
public class KafkaConsumerConfig {
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Object> concurrentKafkaListenerContainerFactory(ConsumerFactory<String, Object> cf){
		ConcurrentKafkaListenerContainerFactory<String, Object> cklcf = new ConcurrentKafkaListenerContainerFactory<>();
		
		cklcf.setConsumerFactory(cf);
		cklcf.getContainerProperties().setAckMode(AckMode.MANUAL);
		return cklcf;
	}
}
