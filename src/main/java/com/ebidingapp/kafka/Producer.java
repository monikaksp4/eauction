package com.ebidingapp.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class Producer {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 private String topicName="tweet";
	public void sendMessage(String msg) {
		logger.info("sent message:"+msg);
	   kafkaTemplate.send(topicName, msg);
	}   

}
