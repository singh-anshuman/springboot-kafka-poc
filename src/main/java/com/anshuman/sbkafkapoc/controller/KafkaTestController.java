package com.anshuman.sbkafkapoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anshuman.sbkafkapoc.service.KafkaTestService;

@RestController
public class KafkaTestController {
	
	@Autowired
	private KafkaTestService kafkaTestService;
	
	public KafkaTestService getKafkaTestService() {
		return kafkaTestService;
	}

	public void setKafkaTestService(KafkaTestService kafkaTestService) {
		this.kafkaTestService = kafkaTestService;
	}


	@PostMapping("/send-message")
	public ResponseEntity<String> sendMessage(@RequestBody String message) {
		kafkaTestService.sendMessage(message);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}