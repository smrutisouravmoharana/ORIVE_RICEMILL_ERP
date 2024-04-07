package com.orive.Customer.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
