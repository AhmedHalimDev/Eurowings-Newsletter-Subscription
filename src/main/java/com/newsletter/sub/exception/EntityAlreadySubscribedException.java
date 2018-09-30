package com.newsletter.sub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for checking the email existence validation.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Account is already subscribed...")
public class EntityAlreadySubscribedException extends Exception {

	static final long serialVersionUID = -3387516993224229948L;

	public EntityAlreadySubscribedException(String message) {
		super(message);
	}

}
