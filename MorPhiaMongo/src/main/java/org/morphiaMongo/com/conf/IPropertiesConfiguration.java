package org.morphiaMongo.com.conf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface IPropertiesConfiguration {

	public static final String MONGO_DBNAME = "Mongo.dbName";
	public static final String MONGO_DBHOST = "Mongo.dbHost";
	public static final String MONGO_DBPORT = "Mongo.dbPort";
	public static final String MONGO_ITEMS = "Mongo.items";

	public static final Map<String, String> NAMES = Collections.unmodifiableMap(

	new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put(MONGO_DBNAME, MONGO_DBNAME);
			put(MONGO_DBHOST, MONGO_DBHOST);
			put(MONGO_DBPORT, MONGO_DBPORT);
			put(MONGO_ITEMS, MONGO_ITEMS);
		}

	});

	void putItem(String field, String property);

	String getItem(String field);
}
