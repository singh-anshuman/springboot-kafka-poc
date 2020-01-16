package com.anshuman.sbkafkapoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaTestService {
	
	@Autowired
	public KafkaTemplate<String, String> kafkaTemplate;
	
	private static String TOPIC="first_topic";

	public KafkaTemplate<String, String> getKafkaTemplate() {
		return kafkaTemplate;
	}

	public void setKafkaTemplate(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC, message);
	}
	
	@KafkaListener(topics = {"first_topic"},groupId = "group_id")
	public void consumeMessage(String message) {
		System.out.println(message);
	}
}