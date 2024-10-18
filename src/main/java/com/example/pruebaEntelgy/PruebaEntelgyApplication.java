package com.example.pruebaEntelgy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PruebaEntelgyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaEntelgyApplication.class, args);
	}

	// Definición del bean RestTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
