package com.newsletter.sub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Home Controller to redirect to Swagger UI.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@Controller
@ApiIgnore
public class HomeController {

	/**
	 * Redirect to swagger.
	 * 
	 * @return String
	 */
	@RequestMapping("/")
	public String home() {
		return "redirect:swagger-ui.html";
	}
}