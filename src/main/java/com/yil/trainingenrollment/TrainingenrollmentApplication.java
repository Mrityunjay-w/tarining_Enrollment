package com.yil.trainingenrollment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;

@SpringBootApplication
public class TrainingenrollmentApplication extends SpringServletContainerInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TrainingenrollmentApplication.class, args);
	}

}
