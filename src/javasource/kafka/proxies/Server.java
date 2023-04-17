// This file was generated by Mendix Studio Pro.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package kafka.proxies;

public class Server
{
	private final com.mendix.systemwideinterfaces.core.IMendixObject serverMendixObject;

	private final com.mendix.systemwideinterfaces.core.IContext context;

	/**
	 * Internal name of this entity
	 */
	public static final java.lang.String entityName = "Kafka.Server";

	/**
	 * Enum describing members of this entity
	 */
	public enum MemberNames
	{
		Reference("Reference"),
		Name("Name"),
		Server_Config("Kafka.Server_Config"),
		Server_TrustStore("Kafka.Server_TrustStore"),
		Server_KeyStore("Kafka.Server_KeyStore");

		private final java.lang.String metaName;

		MemberNames(java.lang.String s)
		{
			metaName = s;
		}

		@java.lang.Override
		public java.lang.String toString()
		{
			return metaName;
		}
	}

	public Server(com.mendix.systemwideinterfaces.core.IContext context)
	{
		this(context, com.mendix.core.Core.instantiate(context, entityName));
	}

	protected Server(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject serverMendixObject)
	{
		if (serverMendixObject == null) {
			throw new java.lang.IllegalArgumentException("The given object cannot be null.");
		}
		if (!com.mendix.core.Core.isSubClassOf(entityName, serverMendixObject.getType())) {
			throw new java.lang.IllegalArgumentException(String.format("The given object is not a %s", entityName));
		}	

		this.serverMendixObject = serverMendixObject;
		this.context = context;
	}

	/**
	 * @deprecated Use 'Server.load(IContext, IMendixIdentifier)' instead.
	 */
	@java.lang.Deprecated
	public static kafka.proxies.Server initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		return kafka.proxies.Server.load(context, mendixIdentifier);
	}

	/**
	 * Initialize a proxy using context (recommended). This context will be used for security checking when the get- and set-methods without context parameters are called.
	 * The get- and set-methods with context parameter should be used when for instance sudo access is necessary (IContext.createSudoClone() can be used to obtain sudo access).
	 * @param context The context to be used
	 * @param mendixObject The Mendix object for the new instance
	 * @return a new instance of this proxy class
	 */
	public static kafka.proxies.Server initialize(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixObject mendixObject)
	{
		return new kafka.proxies.Server(context, mendixObject);
	}

	public static kafka.proxies.Server load(com.mendix.systemwideinterfaces.core.IContext context, com.mendix.systemwideinterfaces.core.IMendixIdentifier mendixIdentifier) throws com.mendix.core.CoreException
	{
		com.mendix.systemwideinterfaces.core.IMendixObject mendixObject = com.mendix.core.Core.retrieveId(context, mendixIdentifier);
		return kafka.proxies.Server.initialize(context, mendixObject);
	}

	public static java.util.List<kafka.proxies.Server> load(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String xpathConstraint) throws com.mendix.core.CoreException
	{
		return com.mendix.core.Core.createXPathQuery(String.format("//%1$s%2$s", entityName, xpathConstraint))
			.execute(context)
			.stream()
			.map(obj -> kafka.proxies.Server.initialize(context, obj))
			.collect(java.util.stream.Collectors.toList());
	}

	/**
	 * Commit the changes made on this proxy object.
	 * @throws com.mendix.core.CoreException
	 */
	public final void commit() throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Commit the changes made on this proxy object using the specified context.
	 * @throws com.mendix.core.CoreException
	 */
	public final void commit(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		com.mendix.core.Core.commit(context, getMendixObject());
	}

	/**
	 * Delete the object.
	 */
	public final void delete()
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}

	/**
	 * Delete the object using the specified context.
	 */
	public final void delete(com.mendix.systemwideinterfaces.core.IContext context)
	{
		com.mendix.core.Core.delete(context, getMendixObject());
	}
	/**
	 * @return value of Reference
	 */
	public final java.lang.Long getReference()
	{
		return getReference(getContext());
	}

	/**
	 * @param context
	 * @return value of Reference
	 */
	public final java.lang.Long getReference(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.Long) getMendixObject().getValue(context, MemberNames.Reference.toString());
	}

	/**
	 * Set value of Reference
	 * @param reference
	 */
	public final void setReference(java.lang.Long reference)
	{
		setReference(getContext(), reference);
	}

	/**
	 * Set value of Reference
	 * @param context
	 * @param reference
	 */
	public final void setReference(com.mendix.systemwideinterfaces.core.IContext context, java.lang.Long reference)
	{
		getMendixObject().setValue(context, MemberNames.Reference.toString(), reference);
	}

	/**
	 * @return value of Name
	 */
	public final java.lang.String getName()
	{
		return getName(getContext());
	}

	/**
	 * @param context
	 * @return value of Name
	 */
	public final java.lang.String getName(com.mendix.systemwideinterfaces.core.IContext context)
	{
		return (java.lang.String) getMendixObject().getValue(context, MemberNames.Name.toString());
	}

	/**
	 * Set value of Name
	 * @param name
	 */
	public final void setName(java.lang.String name)
	{
		setName(getContext(), name);
	}

	/**
	 * Set value of Name
	 * @param context
	 * @param name
	 */
	public final void setName(com.mendix.systemwideinterfaces.core.IContext context, java.lang.String name)
	{
		getMendixObject().setValue(context, MemberNames.Name.toString(), name);
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Server_Config
	 */
	public final kafka.proxies.Config getServer_Config() throws com.mendix.core.CoreException
	{
		return getServer_Config(getContext());
	}

	/**
	 * @param context
	 * @return value of Server_Config
	 * @throws com.mendix.core.CoreException
	 */
	public final kafka.proxies.Config getServer_Config(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		kafka.proxies.Config result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Server_Config.toString());
		if (identifier != null) {
			result = kafka.proxies.Config.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of Server_Config
	 * @param server_config
	 */
	public final void setServer_Config(kafka.proxies.Config server_config)
	{
		setServer_Config(getContext(), server_config);
	}

	/**
	 * Set value of Server_Config
	 * @param context
	 * @param server_config
	 */
	public final void setServer_Config(com.mendix.systemwideinterfaces.core.IContext context, kafka.proxies.Config server_config)
	{
		if (server_config == null) {
			getMendixObject().setValue(context, MemberNames.Server_Config.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.Server_Config.toString(), server_config.getMendixObject().getId());
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Server_TrustStore
	 */
	public final kafka.proxies.KeyStore getServer_TrustStore() throws com.mendix.core.CoreException
	{
		return getServer_TrustStore(getContext());
	}

	/**
	 * @param context
	 * @return value of Server_TrustStore
	 * @throws com.mendix.core.CoreException
	 */
	public final kafka.proxies.KeyStore getServer_TrustStore(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		kafka.proxies.KeyStore result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Server_TrustStore.toString());
		if (identifier != null) {
			result = kafka.proxies.KeyStore.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of Server_TrustStore
	 * @param server_truststore
	 */
	public final void setServer_TrustStore(kafka.proxies.KeyStore server_truststore)
	{
		setServer_TrustStore(getContext(), server_truststore);
	}

	/**
	 * Set value of Server_TrustStore
	 * @param context
	 * @param server_truststore
	 */
	public final void setServer_TrustStore(com.mendix.systemwideinterfaces.core.IContext context, kafka.proxies.KeyStore server_truststore)
	{
		if (server_truststore == null) {
			getMendixObject().setValue(context, MemberNames.Server_TrustStore.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.Server_TrustStore.toString(), server_truststore.getMendixObject().getId());
		}
	}

	/**
	 * @throws com.mendix.core.CoreException
	 * @return value of Server_KeyStore
	 */
	public final kafka.proxies.KeyStore getServer_KeyStore() throws com.mendix.core.CoreException
	{
		return getServer_KeyStore(getContext());
	}

	/**
	 * @param context
	 * @return value of Server_KeyStore
	 * @throws com.mendix.core.CoreException
	 */
	public final kafka.proxies.KeyStore getServer_KeyStore(com.mendix.systemwideinterfaces.core.IContext context) throws com.mendix.core.CoreException
	{
		kafka.proxies.KeyStore result = null;
		com.mendix.systemwideinterfaces.core.IMendixIdentifier identifier = getMendixObject().getValue(context, MemberNames.Server_KeyStore.toString());
		if (identifier != null) {
			result = kafka.proxies.KeyStore.load(context, identifier);
		}
		return result;
	}

	/**
	 * Set value of Server_KeyStore
	 * @param server_keystore
	 */
	public final void setServer_KeyStore(kafka.proxies.KeyStore server_keystore)
	{
		setServer_KeyStore(getContext(), server_keystore);
	}

	/**
	 * Set value of Server_KeyStore
	 * @param context
	 * @param server_keystore
	 */
	public final void setServer_KeyStore(com.mendix.systemwideinterfaces.core.IContext context, kafka.proxies.KeyStore server_keystore)
	{
		if (server_keystore == null) {
			getMendixObject().setValue(context, MemberNames.Server_KeyStore.toString(), null);
		} else {
			getMendixObject().setValue(context, MemberNames.Server_KeyStore.toString(), server_keystore.getMendixObject().getId());
		}
	}

	/**
	 * @return the IMendixObject instance of this proxy for use in the Core interface.
	 */
	public final com.mendix.systemwideinterfaces.core.IMendixObject getMendixObject()
	{
		return serverMendixObject;
	}

	/**
	 * @return the IContext instance of this proxy, or null if no IContext instance was specified at initialization.
	 */
	public final com.mendix.systemwideinterfaces.core.IContext getContext()
	{
		return context;
	}

	@java.lang.Override
	public boolean equals(Object obj)
	{
		if (obj == this) {
			return true;
		}
		if (obj != null && getClass().equals(obj.getClass()))
		{
			final kafka.proxies.Server that = (kafka.proxies.Server) obj;
			return getMendixObject().equals(that.getMendixObject());
		}
		return false;
	}

	@java.lang.Override
	public int hashCode()
	{
		return getMendixObject().hashCode();
	}

	/**
	 * @return String name of this class
	 */
	public static java.lang.String getType()
	{
		return entityName;
	}

	/**
	 * @return String GUID from this object, format: ID_0000000000
	 * @deprecated Use getMendixObject().getId().toLong() to get a unique identifier for this object.
	 */
	@java.lang.Deprecated
	public java.lang.String getGUID()
	{
		return "ID_" + getMendixObject().getId().toLong();
	}
}
