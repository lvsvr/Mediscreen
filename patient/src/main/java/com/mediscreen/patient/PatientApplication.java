package com.mediscreen.patient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type PatientApplication microservice
 */
@SpringBootApplication
public class PatientApplication {
	private static final Logger logger = LogManager.getLogger("tourGuide");
	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
		logger.info("patient initialized");
	}

}
