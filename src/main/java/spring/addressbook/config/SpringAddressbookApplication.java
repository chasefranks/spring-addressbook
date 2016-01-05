package spring.addressbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import spring.addressbook.data.EntryRepository;
import spring.addressbook.data.MongoDBEntryRepository;

@SpringBootApplication
@ComponentScan({"spring.addressbook.web"})
public class SpringAddressbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAddressbookApplication.class, args);
    }
    
    // mongodb properties injected from application.properties
    @Value("${mongodb.host}")
	private String mongoHost;
    
    @Value("${mongodb.port}")
    private String port;
    
    @Value("${mongodb.database}")
    private String database;
    
    @Value("${mongodb.collection}")
    private String collection;
    
    @Bean
    public MongoClient createMongoClient() {
    	
    	MongoClientURI mongoUri = new MongoClientURI("mongodb://" + mongoHost + ":" + port);    	
    	return new MongoClient(mongoUri);
    	
    }
    
    @Bean
    @Autowired
    public EntryRepository createRepo(MongoClient client) {
    	
    	return new MongoDBEntryRepository(client, database, collection);
    	
    }
    
}
