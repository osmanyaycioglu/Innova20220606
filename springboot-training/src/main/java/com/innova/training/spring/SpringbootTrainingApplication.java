package com.innova.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTrainingApplication.class, args);
	}

}
