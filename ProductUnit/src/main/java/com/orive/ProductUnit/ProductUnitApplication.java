package com.orive.ProductUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductUnitApplication.class, args);
	}

}
