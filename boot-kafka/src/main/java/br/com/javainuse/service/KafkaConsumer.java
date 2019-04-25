package br.com.javainuse.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "java_in_use_topic", group = "group_id")
	public void consumer(@Payload String message) {
		LOG.info("received message='{}'", message);

	}

}
