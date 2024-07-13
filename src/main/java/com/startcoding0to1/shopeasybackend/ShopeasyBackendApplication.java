package com.startcoding0to1.shopeasybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ShopeasyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopeasyBackendApplication.class, args);
	}
}
