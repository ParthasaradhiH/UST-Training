package com.ust.LaptopFilter_Jpastreamer_Application.service;

import com.ust.LaptopFilter_Jpastreamer_Application.LaptopFilterJpastreamerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.ust.LaptopFilter_Jpastreamer_Application", "com.speedment.jpastreamer"})

public class Laptopservice {
    public static void main(String[] args) {
        SpringApplication.run(LaptopFilterJpastreamerApplication.class, args);
    }
}
