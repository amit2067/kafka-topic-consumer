package uk.sk.kafka.messaging.kafkasample.topicconsumer.pojos;

public class ConsumerFailure {

    private String messageType;

    private String topic;
    
    private String groupId;
    
    private long offset;

    private String value;

    public ConsumerFailure() {
    }

	public ConsumerFailure(String messageType, String topic, String groupId, long offset, String value) {
		super();
		this.messageType = messageType;
		this.topic = topic;
		this.groupId = groupId;
		this.offset = offset;
		this.value = value;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public long getOffset() {
		return offset;
	}

	public void setOffset(long offset) {
		this.offset = offset;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ConsumerFailures [messageType=" + messageType + ", topic=" + topic + ", groupId="
				+ groupId + ", offset=" + offset + ", value=" + value + "]";
	}
    
}