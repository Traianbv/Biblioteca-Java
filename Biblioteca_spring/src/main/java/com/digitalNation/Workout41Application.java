package com.digitalNation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repository")
@EntityScan("com.digitalNation")
public class Workout41Application {

	public static void main(String[] args) {
		SpringApplication.run(Workout41Application.class, args);
	}

}
