package com.example.studydiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class StudyDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyDiscoveryServerApplication.class, args);
	}

}
