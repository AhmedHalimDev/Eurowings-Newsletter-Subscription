package com.newsletter.sub.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.newsletter.sub.controller.mapper.SubscriberMapper;
import com.newsletter.sub.datatransferobject.SubscriberDTO;
import com.newsletter.sub.domainobject.SubscriberDO;
import com.newsletter.sub.exception.EntityAlreadySubscribedException;
import com.newsletter.sub.exception.EntityAlreadyUnSubscribedException;
import com.newsletter.sub.exception.EntityNotFoundException;
import com.newsletter.sub.service.NewsletterService;

/**
 * Newsletter Subscriber API.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@RestController
@RequestMapping("/service/subscribers")
public class SubscriptionController {
		
	/** Newsletter Service*/
	@Autowired
	private NewsletterService service;
	
	/**
	 * Constructor
	 * @param service
	 */
	@Autowired
	public SubscriptionController(final NewsletterService service) {
		this.service = service;
	}
	/**
	 * list by status
	 * @param active
	 * @return List
	 */
	@GetMapping("/")
	public List<SubscriberDTO> list(@Valid @RequestParam("active") Boolean active){
		return SubscriberMapper.makeSubscriberDTOList(service.findByActive(active));
	}
	/**
	 * Subscriber a user
	 * @param subscriberDTO
	 * @return SubscriberDTO
	 * @throws EntityAlreadySubscribedException
	 */
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public SubscriberDTO subscribe(@RequestBody SubscriberDTO subscriberDTO) throws EntityAlreadySubscribedException {
		SubscriberDO subscriberDO = SubscriberMapper.makeSubscriberDO(subscriberDTO);
		return SubscriberMapper.makeSubscriberDTO(service.subscribe(subscriberDO));
	}
	/**
	 * Un-subscribe a user
	 * @param email
	 * @return SubscriberDTO
	 * @throws EntityNotFoundException
	 *   ,EntityAlreadyUnSubscribedException
	 */
	@DeleteMapping("/unsubscribe")
	public SubscriberDTO usubscribe(@Valid @RequestParam("email") String email) throws EntityNotFoundException, EntityAlreadyUnSubscribedException {
		return SubscriberMapper.makeSubscriberDTO(service.unSubscribe(email));
	}
	/**
	 * Get status of user's email.
	 * 
	 * @param email
	 * @return String
	 * @throws EntityNotFoundException
	 */
	@GetMapping("/bystatus")
	public String status(@Valid @RequestParam("email") String email) throws EntityNotFoundException {
		SubscriberDO subscriber = service.findByEmail(email);
		JSONObject outputJsonObj = new JSONObject();
		outputJsonObj.put("active", subscriber.getActive());
	    return outputJsonObj.toString();
	}
	/**
	 * list users subscribed before a given date
	 * 
	 * @param date
	 * @return List
	 */
	@GetMapping("/bydate")
	public List<SubscriberDTO> listByDate(@Valid @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		return SubscriberMapper.makeSubscriberDTOList(service.findByDate(date));
	}
}