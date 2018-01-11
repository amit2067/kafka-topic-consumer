package uk.sk.kafka.messaging.kafkasample.topicconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaTopicConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaTopicConsumerApplication.class, args);
	}
}