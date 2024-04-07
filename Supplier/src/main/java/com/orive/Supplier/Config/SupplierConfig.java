package com.orive.Supplier.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class SupplierConfig {

	    @Bean
	    public ModelMapper modelMapperBean() {
	        return new ModelMapper();
	    }
}
