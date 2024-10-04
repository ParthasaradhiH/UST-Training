package com.ust.LaptopFilter_Jpastreamer_Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LaptopFilterJpastreamerApplication {

	public static void main(String[] args) {

		SpringApplication.run(LaptopFilterJpastreamerApplication.class, args);
	}

}
