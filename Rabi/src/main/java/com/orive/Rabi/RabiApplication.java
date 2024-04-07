package com.orive.Rabi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class RabiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabiApplication.class, args);
	}

}
