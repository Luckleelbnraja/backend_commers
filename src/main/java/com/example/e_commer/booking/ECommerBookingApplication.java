package com.example.e_commer.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class ECommerBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerBookingApplication.class, args);
	}

}
