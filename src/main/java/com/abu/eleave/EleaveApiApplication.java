package com.abu.eleave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EleaveApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EleaveApiApplication.class, args);
	}

}

