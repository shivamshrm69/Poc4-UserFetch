package com.poc4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Poc4UserFetchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc4UserFetchApplication.class, args);
	}

}
