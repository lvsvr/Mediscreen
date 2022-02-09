package com.mediscreen.userInterface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * The type UserInterfaceApplication microservice
 */
@SpringBootApplication
@EnableFeignClients("com.mediscreen.userInterface")
public class UserInterfaceApplication {
	private static final Logger logger = LogManager.getLogger("userInterface");
	public static void main(String[] args) {
		SpringApplication.run(UserInterfaceApplication.class, args);
		logger.info("userInterface initialized");
	}

}
