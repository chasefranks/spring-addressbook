package spring.addressbook.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import spring.addressbook.data.EntryRepository;
import spring.addressbook.data.MongoDBEntryRepository;

@SpringBootApplication
@ComponentScan({"spring.addressbook.web"})
public class SpringAddressbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAddressbookApplication.class, args);
    }
    
    @Bean
    public EntryRepository createRepo() {
    	return new MongoDBEntryRepository("addressbook", "entries");
    }
}
