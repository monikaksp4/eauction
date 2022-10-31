package com.ebidingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ebidingapp.kafka.Consumer;
import com.ebidingapp.kafka.Producer;

@RestController
public class KafkaController {
	@Autowired
	Producer producer;
	
	@GetMapping(value="/sendMessage")
	public String sendMessage(@RequestParam(name="message") String message) {
		producer.sendMessage(message);
		return "message sent";
		
	}
	

}
