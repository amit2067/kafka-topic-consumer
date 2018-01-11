package uk.sk.kafka.messaging.kafkasample.topicconsumer.consumer;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import uk.sk.kafka.messaging.kafkasample.topicconsumer.pojos.Application;
import uk.sk.kafka.messaging.kafkasample.topicconsumer.pojos.Subscriber;

@Component
public class KafkaTopicConsumer {

	@Value(value = "${kafka.groupid}") private String groupId;
	@Autowired private Subscriber subcriber;
	@Autowired private RestTemplate restTemplate;
		
	@KafkaListener(topics = "APPLICATION", group = "HE_COMMON")
	public void listen(Application application) {
		publish(application);
	    System.out.println("Application Received: " + application);
	}
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		//MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		//converter.setObjectMapper(new ObjectMapper());
		//restTemplate.getMessageConverters().add(converter);
		return restTemplate;
	}
	
	private void publish(Application application) {
		Set<String> subscribers = subcriber.getSubscribers();
		for (String subscriberUrl : subscribers) {
			try {
				ResponseEntity<HttpStatus> response 
					= restTemplate.postForEntity(subscriberUrl, application, HttpStatus.class);
				System.out.println("Application published to : " + subscriberUrl + ", with response: " + response.getStatusCodeValue());
			} catch (Exception ex) {
				System.out.println("Failed to send APPLICATION to subscriber: "+ subscriberUrl);
			}
		}
	}
}