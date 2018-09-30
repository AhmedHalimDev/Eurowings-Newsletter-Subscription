package com.newsletter.sub.service;

import java.util.Date;
import java.util.List;

import com.newsletter.sub.domainobject.SubscriberDO;
import com.newsletter.sub.exception.EntityAlreadySubscribedException;
import com.newsletter.sub.exception.EntityAlreadyUnSubscribedException;
import com.newsletter.sub.exception.EntityNotFoundException;

/**
 * Service interface to encapsulate the link between DAO and controller and to
 * have business logic for newsletter subscriber application.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
public interface NewsletterService {
	
	/**
	 * Subscribe a user
	 * @param subscriber
	 * @return SubscriberDO
	 * @throws EntityAlreadySubscribedException
	 */
	SubscriberDO subscribe(SubscriberDO subscriber)  throws EntityAlreadySubscribedException;
	/**
	 * Un-Subscribe a user
	 * @param email
	 * @return SubscriberDO
	 * @throws EntityNotFoundException
	 * 		 , EntityAlreadyUnSubscribedException
	 */
	SubscriberDO unSubscribe(String email) throws EntityNotFoundException, EntityAlreadyUnSubscribedException;
	/**
	 * Find all users subscribed or unsubscribed.
	 * @param active
	 * @return List
	 */
	List<SubscriberDO> findByActive(Boolean active);
	/**
	 * Find Subscriber By Email.
	 * @param email
	 * @return SubscriberDO
	 * @throws EntityNotFoundException
	 */
	SubscriberDO findByEmail(String email) throws EntityNotFoundException;
	/**
	 * list users subscribed before a given date
	 * 
	 * @param date
	 * @return List
	 */
	List<SubscriberDO> findByDate(Date date);
}