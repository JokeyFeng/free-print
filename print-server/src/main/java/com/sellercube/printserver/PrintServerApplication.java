package com.sellercube.printserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PrintServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrintServerApplication.class, args);
	}
}
