package kafkamodule.actions;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerRepository {
	private static Map<String, KafkaProducerWrapper> producers = new HashMap<String, KafkaProducerWrapper>(); 	
	
	public static void put(String name, KafkaProducerWrapper producer) {
		producers.put(name, producer);
	}
	
	public static KafkaProducerWrapper get(String name)
	{
		return producers.get(name);
	}
	
	public static void close(String name) {
		KafkaProducerWrapper producer = producers.get(name);
		if (producer != null) {
			producer.close();
		}	
	}
	
	public static void closeAll()
	{
		for (KafkaProducerWrapper producer : producers.values()) {
			producer.close();
		}
	}
}
