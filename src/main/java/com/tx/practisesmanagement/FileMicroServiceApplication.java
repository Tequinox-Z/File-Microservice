package com.tx.practisesmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient						// Enable the register as client
/**
 * Initialize the aplication
 * @author Salvador
 */
public class FileMicroServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FileMicroServiceApplication.class, args);
	}

}
