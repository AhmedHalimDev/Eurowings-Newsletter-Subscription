package com.newsletter.sub.domainobject;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Subscriber Domain Object.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@Entity
@Table(name = "subscriber", uniqueConstraints = @UniqueConstraint(name = "uc_email", columnNames = { "email" }))
@Data
public class SubscriberDO {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(nullable = false)
	@NotNull(message = "Email can not be null!")
	private String email;
	@Column(nullable = false)
	@NotNull(message = "Name can not be null!")
	private String name;
	@Column
	private Boolean active = true;
	@Column(nullable = false)
	private LocalDateTime subscribeDate = LocalDateTime.now();
	
	/**
	 * Default Constructor
	 */
	public SubscriberDO() {
		
	}
	/**
	 * Constructor.
	 * @param id
	 * @param email
	 * @param name
	 */
	public SubscriberDO(Long id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}
}