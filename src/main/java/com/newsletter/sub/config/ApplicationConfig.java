package com.newsletter.sub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Application Configuration class is responsible for configuring security for
 * the Rest API and configuring users.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@Configuration
@EnableSwagger2
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BasicAuthenticationPoint basicAuthenticationPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/newsletter/**").hasRole("ADMIN").and().httpBasic()
				.authenticationEntryPoint(basicAuthenticationPoint);
		http.authorizeRequests().antMatchers("/", "/newsletter/**").permitAll()
		.anyRequest().authenticated();
	}

	/**
	 * Configure Global.
	 * 
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("02468").roles("ADMIN");
	}
}
