package kafkamodule.actions;

import org.apache.kafka.common.serialization.*;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;

import org.apache.kafka.connect.json.JsonDeserializer;
import org.apache.kafka.connect.json.JsonSerializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class FilteredKafkaProcessor extends KafkaProcessor {
	protected String jsonPointer;
	protected String filterValue;
	
	public FilteredKafkaProcessor(IMendixObject config, IContext context, String fromTopic, String jsonPointer, String filterValue, String toTopic, String onProcessMicroflow) {
		super(config, context, fromTopic, toTopic, onProcessMicroflow);
		this.jsonPointer = jsonPointer;
		this.filterValue = filterValue;
	}

	private final Serializer<JsonNode> jsonSerializer = new JsonSerializer();
	private final Deserializer<JsonNode> jsonDeserializer = new JsonDeserializer();

	private final Serde<String> stringSerde = Serdes.String();
	private final Serde<JsonNode> jsonSerde = Serdes.serdeFrom(jsonSerializer, jsonDeserializer);
	
	@Override
	public void start() throws CoreException {
		StreamsConfig config = new StreamsConfig(props);
		StreamsBuilder builder = new StreamsBuilder();

		KStream<String, JsonNode> stream = builder.stream(
			fromTopic,
			Consumed.with(stringSerde, jsonSerde));
		
		stream
			.filter((key, value) -> value.at(jsonPointer).toString() == filterValue)
			.flatMap((key, value) -> apply(key, value.toString(), onProcessMicroflow));
		if (toTopic != null && !toTopic.isEmpty()) {
			stream.to(toTopic);
		}
		streams = new KafkaStreams(builder.build(), config);
		streams.start();
	}
}
