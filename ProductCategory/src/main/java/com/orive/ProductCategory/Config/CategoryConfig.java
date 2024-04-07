package com.orive.ProductCategory.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CategoryConfig {

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
