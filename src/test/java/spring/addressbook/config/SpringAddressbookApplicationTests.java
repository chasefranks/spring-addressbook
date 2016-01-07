package spring.addressbook.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.addressbook.SpringAddressbookApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringAddressbookApplication.class)
@WebAppConfiguration
public class SpringAddressbookApplicationTests {

	@Test
	public void contextLoads() {
	}

}
