// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package kafka.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import kafka.impl.FilteredKafkaProcessor;
import kafka.impl.KafkaProcessor;
import kafka.impl.KafkaProcessorRepository;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * This action will listen to a topic, and start a microflow for each JSON message in that topic that passes a filter.
 * 
 * The filter is specified as the value at a certain place inside the message.
 * 
 * This action will always return true.
 */
public class StartFilteredProcessor extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String name;
	private IMendixObject __configuration;
	private kafka.proxies.StreamsConfig configuration;
	private java.lang.String fromTopic;
	private java.lang.String jsonPointer;
	private java.lang.String filterValue;
	private java.lang.String toTopic;
	private java.lang.String onProcess;

	public StartFilteredProcessor(IContext context, java.lang.String name, IMendixObject configuration, java.lang.String fromTopic, java.lang.String jsonPointer, java.lang.String filterValue, java.lang.String toTopic, java.lang.String onProcess)
	{
		super(context);
		this.name = name;
		this.__configuration = configuration;
		this.fromTopic = fromTopic;
		this.jsonPointer = jsonPointer;
		this.filterValue = filterValue;
		this.toTopic = toTopic;
		this.onProcess = onProcess;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.configuration = this.__configuration == null ? null : kafka.proxies.StreamsConfig.initialize(getContext(), __configuration);

		// BEGIN USER CODE
		KafkaProcessor processor = new FilteredKafkaProcessor(this.configuration.getMendixObject(), 
				getContext(), fromTopic, jsonPointer, filterValue, toTopic, onProcess); 
		processor.start();
		KafkaProcessorRepository.put(name, processor);
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "StartFilteredProcessor";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
