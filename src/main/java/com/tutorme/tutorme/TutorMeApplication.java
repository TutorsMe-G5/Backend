package com.tutorme.tutorme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.tutorme.tutorme", "com.tutorme.tutorme.shared.cors"})
public class TutorMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorMeApplication.class, args);
	}

}
