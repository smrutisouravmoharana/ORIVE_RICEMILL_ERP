package com.orive.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class Supplier {

	public static void main(String[] args) {
		SpringApplication.run(Supplier.class, args);
		System.out.println("hello ERP User");
	}

}
