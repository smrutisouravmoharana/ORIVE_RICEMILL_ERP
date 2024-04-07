package com.orive.Kharif.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrokerConfig {
	
	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
