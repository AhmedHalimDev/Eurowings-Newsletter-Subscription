package com.newsletter.sub.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsletter.sub.dataaccessobject.SubscriberRepository;
import com.newsletter.sub.domainobject.SubscriberDO;
import com.newsletter.sub.exception.EntityAlreadySubscribedException;
import com.newsletter.sub.exception.EntityAlreadyUnSubscribedException;
import com.newsletter.sub.exception.EntityNotFoundException;
import com.newsletter.sub.service.NewsletterService;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for newsletter subscribers.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@Service
public class NewsletterServiceImpl implements NewsletterService {

	@Autowired
	private SubscriberRepository subscriberRepository;
	
	/**
	 * Subscribe a user
	 * @param subscriber
	 * @return SubscriberDO
	 * @throws EntityAlreadySubscribedException
	 */
	@Override
	public SubscriberDO subscribe(SubscriberDO subscriber) throws EntityAlreadySubscribedException {
		Optional<SubscriberDO> existSubscriber = subscriberRepository.findByEmail(subscriber.getEmail());
		if(existSubscriber.isPresent()) {
			if(existSubscriber.get().getActive()) {
				throw new EntityAlreadySubscribedException("Account is already subscribed...");
			}else {
				subscriber.setId(existSubscriber.get().getId());
			}
		}
		return subscriberRepository.save(subscriber);
	}
	/**
	 * Un-Subscribe a user
	 * @param email
	 * @return SubscriberDO
	 * @throws EntityNotFoundException
	 * 		 , EntityAlreadyUnSubscribedException
	 */
	@Override
	public SubscriberDO unSubscribe(String email) throws EntityNotFoundException, EntityAlreadyUnSubscribedException {
		Optional<SubscriberDO> subscriber = subscriberRepository.findByEmail(email);
		if(!subscriber.isPresent()) {
			throw new EntityNotFoundException("There is no subscriber for email input.");
		}
		SubscriberDO subscriberDO = subscriber.get();
		if(!subscriberDO.getActive()) {
			throw new EntityAlreadyUnSubscribedException("Account is already un-subscribed...");
		}
		subscriberDO.setActive(false);
		return subscriberRepository.save(subscriberDO);
	}
	/**
	 * Find all users subscribed or unsubscribed.
	 * @param active
	 * @return List
	 */
	@Override
	public List<SubscriberDO> findByActive(Boolean active) {
		return subscriberRepository.findByActive(active);
	}
	/**
	 * Find Subscriber By Email.
	 * @param email
	 * @return SubscriberDO
	 * @throws EntityNotFoundException
	 */
	@Override
	public List<SubscriberDO> findByDate(Date date) {
		return subscriberRepository.findByDate(date);
	}
	/**
	 * list users subscribed before a given date
	 * 
	 * @param date
	 * @return List
	 */
	@Override
	public SubscriberDO findByEmail(String email) throws EntityNotFoundException {
		Optional<SubscriberDO> subscriber = subscriberRepository.findByEmail(email);
		if(!subscriber.isPresent()) {
			throw new EntityNotFoundException("There is no subscriber for email input.");
		}
		return subscriber.get();
	}
}
