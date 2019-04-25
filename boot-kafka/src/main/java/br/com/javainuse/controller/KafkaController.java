package br.com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.javainuse.service.KafkaConsumer;
import br.com.javainuse.service.KafkaSender;

@RestController
@RequestMapping(value = "/javainuse-kafka/")
public class KafkaController {

	@Autowired
	KafkaSender kafkaSender;
	
	@Autowired
	KafkaConsumer kafkaConsumer;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		kafkaSender.send(message);

		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
	}
	
	@GetMapping(value = "/consumer")
	public String consumer(@RequestParam("message") String message) {
		kafkaConsumer.consumer(message);
		
		return message;
	}
}
