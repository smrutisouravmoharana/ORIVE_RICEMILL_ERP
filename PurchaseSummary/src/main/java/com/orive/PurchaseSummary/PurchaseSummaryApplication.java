package com.orive.PurchaseSummary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PurchaseSummaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseSummaryApplication.class, args);
	}

}
