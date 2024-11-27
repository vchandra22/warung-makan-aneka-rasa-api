package com.warung_makan.aneka_rasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AnekaRasaApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnekaRasaApplication.class, args);
	}
	//
}
