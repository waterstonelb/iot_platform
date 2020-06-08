package com.example.iot_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
public class IotManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotManagerApplication.class, args);
	}

}
