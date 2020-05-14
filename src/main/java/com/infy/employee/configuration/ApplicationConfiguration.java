package com.infy.employee.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.infy.employee.dto.ErrorMessage;

/**
 * @author Sandeep_Meduri
 *
 */
@Configuration
public class ApplicationConfiguration {

	/**
	 * @return
	 */
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
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
