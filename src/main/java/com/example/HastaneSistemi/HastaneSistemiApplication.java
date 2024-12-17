package com.example.HastaneSistemi;

import com.example.HastaneSistemi.service.ClinicService;
import io.swagger.v3.oas.annotations.OpenAPI31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HastaneSistemiApplication {

	@Autowired
	ClinicService clinicService;

	public CommandLineRunner dataInitialize() {
		return args -> {
			clinicService.initializeClinics();
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(HastaneSistemiApplication.class, args);
	}

}
