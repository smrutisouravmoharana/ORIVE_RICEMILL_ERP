package com.orive.InventoryManufacturingJournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryManufacturingJournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryManufacturingJournalApplication.class, args);
	}

}
