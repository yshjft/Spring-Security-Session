package com.springSecurity.SpringSecuritySession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringSecuritySessionApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritySessionApplication.class, args);
	}
}
