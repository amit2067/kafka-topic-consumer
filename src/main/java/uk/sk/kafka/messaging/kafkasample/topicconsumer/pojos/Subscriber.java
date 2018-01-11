package uk.sk.kafka.messaging.kafkasample.topicconsumer.pojos;

import java.util.LinkedHashSet;
import java.util.Set;

public class Subscriber {
	private Set<String> subscribers = new LinkedHashSet<>();
	
	public Set<String> getSubscribers() {
		return subscribers;
	}

	public void addSubscriber(String url) {
		subscribers.add(url);		
	}
	
	public void removeSubscriber(String url) {
		subscribers.remove(url);		
	}
}