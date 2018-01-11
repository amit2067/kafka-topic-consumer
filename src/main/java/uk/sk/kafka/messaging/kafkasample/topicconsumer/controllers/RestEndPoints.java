package uk.sk.kafka.messaging.kafkasample.topicconsumer.controllers;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import uk.sk.kafka.messaging.kafkasample.topicconsumer.pojos.Subscriber;

@Api(value="Kafka Topic Consumer Service")
@RestController
public class RestEndPoints {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired private Subscriber subscribers;
	
	@RequestMapping(method= {RequestMethod.GET})
	public ResponseEntity<?> ping() {
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the list of subscribers",response = String.class)
	@RequestMapping(method= {RequestMethod.GET}, path="/app/subscribe")
	public ResponseEntity<?> getSubscribers() {
		return new ResponseEntity<Set<String>>(subscribers.getSubscribers(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add your rest url as subscriber",response = String.class)
	@RequestMapping(method= {RequestMethod.PUT}, path="/app/subscribe")
	public ResponseEntity<?> addSubscriber(@RequestParam(name="url") String url) {
		logger.info("Application consumer [add - subscriber] request for: "+ url +", Received ");
		subscribers.addSubscriber(url);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "Remove your subscribed rest url",response = String.class)
	@RequestMapping(method= {RequestMethod.DELETE}, path="/app/subscribe")
	public ResponseEntity<?> removeSubscriber(@RequestParam(name="url") String url) {
		logger.info("Application consumer [remove - subscription] request for: "+ url +", Received ");
		subscribers.removeSubscriber(url);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
}