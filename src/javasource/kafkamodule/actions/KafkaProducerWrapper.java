package kafkamodule.actions;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class KafkaProducerWrapper extends KafkaConfigurable {
	Producer<String, String> producer; 
	
	public KafkaProducerWrapper(IMendixObject config, IContext context) {
		super(config, context);
		producer = new KafkaProducer<>(props);
	}
	
	public void send(ProducerRecord record) {
		producer.send(record);
	}
	
	public void close() {
		producer.close();
	}
}
