package com.orive.Sales.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleConfig {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
