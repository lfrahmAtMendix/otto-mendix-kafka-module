// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package kafka.actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

import kafka.impl.KafkaConsumerBinaryRunner;
import kafka.impl.KafkaConsumerRepository;
import kafka.impl.KafkaConsumerRunner;
import kafka.impl.KafkaModule;
import kafka.impl.KafkaPropertiesFactory;
import kafka.proxies.Header;
import kafka.proxies.Message;
import kafka.proxies.ValueType;

import com.mendix.systemwideinterfaces.core.IMendixObject;

public class GetMessagesFromOffset extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private IMendixObject __consumer;
	private kafka.proxies.Consumer consumer;
	private java.lang.String topic;
	private java.lang.Long partition;
	private java.lang.Long offset;
	private java.lang.Long amount;

	public GetMessagesFromOffset(IContext context, IMendixObject consumer, java.lang.String topic, java.lang.Long partition, java.lang.Long offset, java.lang.Long amount)
	{
		super(context);
		this.__consumer = consumer;
		this.topic = topic;
		this.partition = partition;
		this.offset = offset;
		this.amount = amount;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		this.consumer = this.__consumer == null ? null : kafka.proxies.Consumer.initialize(getContext(), __consumer);

		// BEGIN USER CODE
		Properties kafkaProps = KafkaPropertiesFactory.getKafkaProperties(getContext(), consumer);
		kafkaProps.put("enable.auto.commit", "false");
		kafkaProps.put("max.poll.records", amount.intValue());
		kafkaProps.remove("group.id");
		
		List<IMendixObject> result = new LinkedList<>();
		if (this.consumer.getValueType(getContext()) == ValueType.String) {
			KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(kafkaProps);

			try {
				TopicPartition tp = new TopicPartition(topic, partition.intValue());
				kafkaConsumer.assign(Arrays.asList(tp));
				kafkaConsumer.seek(tp, offset);
				ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(5000));
				for (ConsumerRecord<String, String> record : records) {
					Message newMessage = new Message(getContext());
					newMessage.setOffset(record.offset());
					newMessage.setPartition(record.partition());
					newMessage.setTopic(record.topic());
					newMessage.setKey(record.key());
					newMessage.setPayload(record.value());
					newMessage.setTimestamp(new Date(record.timestamp()));
					result.add(newMessage.getMendixObject());
					
					for (org.apache.kafka.common.header.Header header : record.headers()) {
						Header headerObj = new Header(getContext());
						headerObj.setKey(header.key());
						headerObj.setValue(new String(header.value()));
						headerObj.setHeader_Message(newMessage);
					}
					
				}
			} catch (Exception e) {
				KafkaModule.LOGGER.error("Error while obtaining position for " + consumer.getName() + ": " + e.getMessage(), e);
				throw e;
			} finally {
				kafkaConsumer.close();
			}
		} else if (this.consumer.getValueType(getContext()) == ValueType.Binary) {
			KafkaConsumer<String, byte[]> kafkaConsumer = new KafkaConsumer<>(kafkaProps);

			try {
				TopicPartition tp = new TopicPartition(topic, partition.intValue());
				kafkaConsumer.assign(Arrays.asList(tp));
				kafkaConsumer.seek(tp, offset);
				ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(Duration.ofMillis(5000));
				for (ConsumerRecord<String, byte[]> record : records) {
					Message newMessage = new Message(getContext());
					newMessage.setOffset(record.offset());
					newMessage.setPartition(record.partition());
					newMessage.setTopic(record.topic());
					newMessage.setKey(record.key());
					newMessage.setPayload(Base64.getEncoder().encodeToString(record.value()));
					newMessage.setTimestamp(new Date(record.timestamp()));
					result.add(newMessage.getMendixObject());
					
					for (org.apache.kafka.common.header.Header header : record.headers()) {
						Header headerObj = new Header(getContext());
						headerObj.setKey(header.key());
						headerObj.setValue(new String(header.value()));
						headerObj.setHeader_Message(newMessage);
					}
					
				}
			} catch (Exception e) {
				KafkaModule.LOGGER.error("Error while obtaining position for " + consumer.getName() + ": " + e.getMessage(), e);
				throw e;
			} finally {
				kafkaConsumer.close();
			}
		}

		return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetMessagesFromOffset";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
