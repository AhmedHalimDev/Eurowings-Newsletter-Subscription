package com.newsletter.sub.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.newsletter.sub.datatransferobject.SubscriberDTO;
import com.newsletter.sub.domainobject.SubscriberDO;

/**
 * Newsletter Subscriber Mapper for mapping Data Object to Data Transfer Objects and vice versa.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
public class SubscriberMapper {

	/**
	 * Mapping DTO to DO.
	 * 
	 * @param subscriberDTO
	 * @return Subscriber
	 */
	public static SubscriberDO makeSubscriberDO(SubscriberDTO subscriberDTO) {
		SubscriberDO subscriber = new SubscriberDO(subscriberDTO.getId(), subscriberDTO.getEmail(), subscriberDTO.getName());
		return subscriber;
	}
	/**
	 * Mapping DO to DTO.
	 * 
	 * @param subscriber
	 * @return SubscriberDTO
	 */
	public static SubscriberDTO makeSubscriberDTO(SubscriberDO subscriber) {
		SubscriberDTO.SubscriberDTOBuilder subscriberDTOBuilder = SubscriberDTO.newBuilder()
				.setId(subscriber.getId()).setName(subscriber.getName()).setEmail(subscriber.getEmail())
				.setActive(subscriber.getActive()).setSubscribeDate(subscriber.getSubscribeDate());
		return subscriberDTOBuilder.createSubscriberDTO();
	}
	/**
	 * Mapping list of DTO from DO.
	 * 
	 * @param subscribers
	 * @return List<SubscriberDTO>
	 */
	public static List<SubscriberDTO> makeSubscriberDTOList(Collection<SubscriberDO> subscribers) {
		 return subscribers.stream()
		 .map(SubscriberMapper::makeSubscriberDTO)
		 .collect(Collectors.toList());
	}
}
