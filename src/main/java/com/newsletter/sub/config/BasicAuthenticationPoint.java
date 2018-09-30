package com.newsletter.sub.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Application Configuration class is responsible for authentication.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@Component
public class BasicAuthenticationPoint extends BasicAuthenticationEntryPoint {

	/**
	 * Commence user authentication.
	 * 
	 * @param request
	 * @param response
	 * @param authEx
	 * @throws IOException
	 *             , ServletException
	 */
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authEx)
			throws IOException, ServletException {
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status 401 - " + authEx.getMessage());
	}
	/**
	 * Setting properties After instance is created.
	 * 
	 * @throws Exception
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("MyTaxi");
		super.afterPropertiesSet();
	}
}
