package com.newsletter.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main entity for Newsletter Subscriber.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 30.09.2018
 */
@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
public class NewsletterSubscriber extends WebMvcConfigurerAdapter {

	/**
	 * Main method.
	 */
	public static void main(String[] args) {
		SpringApplication.run(NewsletterSubscriber.class, args);
	}

	/**
	 * Provides sensible defaults and convenience methods for configuration.
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(getClass()
						.getPackage().getName())).paths(PathSelectors.any())
				.build().apiInfo(generateApiInfo());
	}

	/**
	 * Generate Web Service API information.
	 * 
	 * @return ApiInfo
	 */
	private ApiInfo generateApiInfo() {
		return new ApiInfo(
				"Newsletter Subscriber.",
				"This service is to simulate a subscriber service for a newsletter.",
				"Version 1.0 - mw", "urn:tos", "ahmed.elgamal.dev@gmail.com",
				"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
}
