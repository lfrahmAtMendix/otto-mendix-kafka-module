package kafkamodule.actions;

import java.util.Properties;

import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IMendixObjectMember;

public class KafkaConfigurable {
	protected final static ILogNode logger = Core.getLogger("Kafka Module");	
	protected Properties props;
	protected IContext context;
	
	public KafkaConfigurable(IMendixObject config, IContext context) {
		this.context = context;
		props = new java.util.Properties();
		for (IMendixObjectMember<?> primitive : config.getPrimitives(context)) {
			String key = primitive.getName().replace('_', '.');
			Object value = primitive.getValue(context); 
			if (value != null) {
				props.put(key, value);
			}
		}
	}
}
