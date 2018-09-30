package com.newsletter.sub.datatransferobject;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Subscriber Data Transfer Object.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SubscriberDTO {
	
	@JsonIgnore
	private Long id;
	@NotNull(message = "Name can not be null!")
	private String name;
	@NotNull(message = "Email can not be null!")
	private String email;
	private Boolean active;
	@JsonIgnore
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime subscribeDate;
	
	/**
	 * Default Constructor.
	 * 
	 */
	private SubscriberDTO() {
	}
	/**
	 * 
	 * @param id
	 * @param email
	 * @param name
	 * @param subscriber
	 * @param subscribeDate
	 */
	private SubscriberDTO(Long id, String email, String name, Boolean active, LocalDateTime subscribeDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.active = active;
		this.subscribeDate = subscribeDate;
	}
	/**
	 * Initializing.
	 * 
	 * @return SubscriberDTOBuilder
	 */
	public static SubscriberDTOBuilder newBuilder() {
		return new SubscriberDTOBuilder();
	}
	@JsonProperty
	public Long getId() {
		return id;
	}
	@JsonProperty
	public String getName() {
		return name;
	}
	@JsonProperty
	public String getEmail() {
		return email;
	}
	@JsonProperty
	public Boolean getActive() {
		return active;
	}
	@JsonProperty
	public LocalDateTime getSubscribeDate() {
		return subscribeDate;
	}
	
	/**
	 * Class for building a Subscriber DTO.
	 * 
	 */
	public static class SubscriberDTOBuilder {
		
		private Long id;
		private String email;
		private String name;
		private Boolean active;
		private LocalDateTime subscribeDate;

		/**
		 * @param id
		 * @return SubscriberDTOBuilder
		 */
		public SubscriberDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		/**
		 * @param email
		 * @return SubscriberDTOBuilder
		 */
		public SubscriberDTOBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		/**
		 * @param name
		 * @return SubscriberDTOBuilder
		 */
		public SubscriberDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * @param active
		 * @return SubscriberDTOBuilder
		 */
		public SubscriberDTOBuilder setActive(Boolean active) {
			this.active = active;
			return this;
		}
		/**
		 * @param subscribeDate
		 * @return SubscriberDTOBuilder
		 */
		public SubscriberDTOBuilder setSubscribeDate(LocalDateTime subscribeDate) {
			this.subscribeDate = subscribeDate;
			return this;
		}
		/**
		 * Create Subscriber DTO.
		 * 
		 * @return SubscriberDTO
		 */
		public SubscriberDTO createSubscriberDTO() {
			return new SubscriberDTO(id, email, name, active, subscribeDate);
		}
	}
}