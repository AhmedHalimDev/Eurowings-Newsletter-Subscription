package com.newsletter.sub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for entity not found.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Could not find entity with id.")
public class EntityNotFoundException extends Exception {
	static final long serialVersionUID = -3387516993334229948L;

	public EntityNotFoundException(String message) {
		super(message);
	}
}
