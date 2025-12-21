package com.app.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.app.model.Order;

@Service
public class KafkaOrderConsumerServiceImpl implements KafkaOrderConsumerService {
	
	@KafkaListener(topics = "order-topic", groupId = "group-1", containerFactory = "concurrentKafkaListenerContainerFactory")
	@Override
	public void processOrder(Order order, Acknowledgment acknowledgment) {
		
		try {
			order.setOrderProcessedBy("processOrder1[group-1]");
			System.out.println(order);
			System.out.println(acknowledgment.toString());
			
			acknowledgment.acknowledge();
		} catch (Exception e) {
			acknowledgment.nack(5000l);
		}
	}
	
}
