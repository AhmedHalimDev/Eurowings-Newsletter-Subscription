package com.newsletter.sub;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Newsletter Subscriber API Tester.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = NewsletterSubscriber.class)
@WebAppConfiguration
@AutoConfigureMockMvc
public class NewsletterSubscriberTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Hello World");
	}
}