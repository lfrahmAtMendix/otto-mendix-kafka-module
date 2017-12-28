# Mendix Kafka Module

Connect your [Mendix](https://www.mendix.com) app to [Apache Kafka](http://kafka.apache.org/intro).

## Usage

This module allows you to:
 * [Produce data](#produce) in Kafka topics
 * [Consume data](#consume) from Kafka topics
 * [Stream data](#stream) between Kafka topics

### <a name="produce"></a>Produce data

Kafka Produce allows you to write data to a topic.

To produce data, you need to start a producer. [All configuration options](http://kafka.apache.org/documentation/#producerconfigs) are available. However, the only configuration information it needs is the Kafka server to connect to and the topic to write to.

You can send a key/value pair to Kafka with the 'Send to Kafka' action.

### <a name="consume"></a>Consume data

Kafka Consume allows you to read data from a topic.

To consume data, you need to start a consumer. [All configuration options](http://kafka.apache.org/documentation/#newconsumerconfigs) are available. However, the only configuration information it needs is the Kafka server to connect to, the topic to read from, and a microflow.

The microflow takes the following parameters:
 - offset (Long): The position of this record in the corresponding Kafka partition.
 - key (String): The key (or null if no key is specified)
 - value (String): The value

The consumer calls the microflow for each message in the topic. If you only want to start the microflow for certain messages, you can use a [filtered processor](#filtered-processor)

### <a name="stream"></a>Stream data

Kafka Streams allows you to read data from one topic, and write data to another.

To stream data between two topics, you need to start a processor. [All configuration options](http://kafka.apache.org/documentation/#streamsconfigs) are available. However, the only configuration information it needs is the Kafka server to connect to, the topic to read from, and a microflow.

The microflow takes the following parameters:
 - offset (Long): The position of this record in the corresponding Kafka partition.
 - key (String): The key (or null if no key is specified)
 - value (String): The value

It may return one of the following:
 - List of KeyValuePair: All these messages will be sent to the output topic.
 - KeyValuePair: This message will be sent to the output topic.
 - String: A message with that value (and no key) will be sent to the output topic
 - Nothing: No messages will be sent to the output topic.

If you start a processor without an output topic, it behaves like a consumer in the sense that it only reads and does not write.

The consumer calls the microflow for each message in the input topic.

#### <a name="filtered-processor"></a>Filtering

You can filter the messages that cause the microflow to execute by starting a _filtered processor_. This works for JSON messages only, and only when you want to filter on a specific part of the JSON message, such as a property value.

### Shut down

Make sure you call the 'Stop all Kafka connections' action before the app stops, for instance during the 'Before shutdown' microflow.

## Features and limitations

Features:
- Supports Producer, Consumer and Streams API's.
- Allows all configuration options
- Allows basic filtering for streams

Limitations:
- Not (yet) integrated with the app's SSL certificates
- More advanced filtering requires custom java

Dependencies:
- Works with Mendix 6.10.9 and up