package com.banco.clientepersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.banco.clientepersona")
public class ClientePersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientePersonaApplication.class, args);
	}

}
