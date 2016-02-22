package spring.addressbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.addressbook.data.EntryRepository;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

/**
 * Mongo configuration class for Spring Addressbook
 * This class configures a MongoClient object in the ApplicationContext
 * 
 * @author chase
 *
 */
@Configuration
public class MongoConfig {
	
	// injected from application.properties
    @Value("${mongodb.host:localhost}")
	private String mongoHost;
    
    @Value("${mongodb.port:27017}")
    private String port;
        
    @Bean()
    public MongoClient createProdMongoClient() {
    	
    	String[] mongoHosts = mongoHost.split(",");
    	String[] mongoPorts = port.split(",");
    	
    	List<ServerAddress> replicaSet = new ArrayList<ServerAddress>();
    	
    	for (int i = 0; i < mongoHosts.length; i++) {
    		replicaSet.add(new ServerAddress(mongoHosts[i].trim(), Integer.parseInt(mongoPorts[i].trim())));
    	}
    	
    	/*
    	 * need to do some checks here
    	 * 
    	 * there must be at least 3 nodes in a mongo replica set
    	 * what if the arrays aren't equal size
    	 */
    			
		return new MongoClient(replicaSet);
		    	
    }
    

}
