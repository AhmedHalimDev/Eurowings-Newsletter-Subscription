package com.newsletter.sub.test.service;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.newsletter.sub.domainobject.SubscriberDO;
import com.newsletter.sub.exception.EntityAlreadySubscribedException;
import com.newsletter.sub.exception.EntityAlreadyUnSubscribedException;
import com.newsletter.sub.exception.EntityNotFoundException;
import com.newsletter.sub.service.NewsletterService;
import com.newsletter.sub.service.impl.NewsletterServiceImpl;

@RunWith(SpringRunner.class)
public class NewsletterSubscriberServiceTest {
	
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public NewsletterService newsletterService() {
            return new NewsletterServiceImpl();
        }
    }
    @Autowired
    private NewsletterService newsletterService;
    
    @Before
    public void setUp() throws EntityNotFoundException {
        SubscriberDO subscriberDO = new SubscriberDO(new Long(0), "test@test.com", "Test");
        Mockito.when(newsletterService.findByEmail(subscriberDO.getEmail())).thenReturn(subscriberDO);
    }
    @Test
    public void testFindByEmail() throws EntityNotFoundException {
        String email = "test@test.com";
        SubscriberDO subscriberDO = newsletterService.findByEmail(email);
        assertTrue(subscriberDO.getEmail().equals(email));
    }
    @Test
    public void testFindActiveList() {
    	List<SubscriberDO> list = newsletterService.findByActive(true);
    	assertTrue(list.size() > 0);
    }
    @Test
    public void testFindInActiveList() {
    	List<SubscriberDO> list = newsletterService.findByActive(false);
    	assertTrue(list.size() > 0);
    }
    @Test
    public void testFindByDateList() {
    	List<SubscriberDO> list = newsletterService.findByDate(new Date());
    	assertTrue(list.size() > 0);
    }
    @Test
    public void testSubscribe() throws EntityAlreadySubscribedException {
    	SubscriberDO subscriber = newsletterService.subscribe(new SubscriberDO(new Long(0), "new@newsletter.de", "New User"));
    	assertTrue(subscriber != null && subscriber.getId() > 0);
    }
    @Test void testUnsubscribe() throws EntityNotFoundException, EntityAlreadyUnSubscribedException {
    	SubscriberDO subscriber = newsletterService.unSubscribe("new@newsletter.de");
    	assertTrue(subscriber != null && !subscriber.getActive());
    }
}
