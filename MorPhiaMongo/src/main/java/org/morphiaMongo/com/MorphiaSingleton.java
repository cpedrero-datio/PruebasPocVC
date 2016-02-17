package org.morphiaMongo.com;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.morphiaMongo.com.conf.ConfigurationSpring;
import org.morphiaMongo.com.conf.FactoryBeans;
import org.morphiaMongo.com.conf.IPropertiesConfiguration;

import java.net.UnknownHostException;

public class MorphiaSingleton {
		private Morphia morphia;
		private Datastore datastore;
		private MongoClient mongoClient;
		private static MorphiaSingleton instance;
		
		static{
			MorphiaSingleton.instance = new MorphiaSingleton();
		}
		private MorphiaSingleton() {
			try {
				IPropertiesConfiguration configdb = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(IPropertiesConfiguration.class);
				mongoClient = new MongoClient(configdb.getItem(IPropertiesConfiguration.MONGO_DBHOST), Integer.valueOf(configdb.getItem(IPropertiesConfiguration.MONGO_DBPORT)));

				morphia = new Morphia();
				morphia.mapPackage("org.morphiaMongo.com.conf.bean");
				datastore = morphia.createDatastore(mongoClient, configdb.getItem(IPropertiesConfiguration.MONGO_DBNAME));
				datastore.ensureIndexes();
			}catch (Exception e){
				e.printStackTrace();
			}
		}					
		
		public static MorphiaSingleton getInstance(){
			return instance;
		}

		public Datastore getDatastore() {
			return datastore;
		}
		
		
}
