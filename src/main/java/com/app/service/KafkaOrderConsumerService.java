package com.app.service;

import org.springframework.kafka.support.Acknowledgment;

import com.app.model.Order;

public interface KafkaOrderConsumerService {
	public void processOrder(Order order, Acknowledgment aknowAcknowledgment);
}
