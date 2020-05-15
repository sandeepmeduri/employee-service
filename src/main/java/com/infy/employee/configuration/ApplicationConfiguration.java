package com.infy.employee.configuration;

import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.infy.employee.dto.ErrorMessage;

/**
 * @author Sandeep_Meduri
 *
 */
/**
 * @author Sandeep_Meduri
 *
 */
@Configuration
public class ApplicationConfiguration {

	
	/**
	 * @param builder
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofSeconds(2)).setReadTimeout(Duration.ofSeconds(2)).build();
	}

	/**
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	/**
	 * @return
	 */
	@Bean
	public ErrorMessage errorMessage() {
		return new ErrorMessage();
	}

}
