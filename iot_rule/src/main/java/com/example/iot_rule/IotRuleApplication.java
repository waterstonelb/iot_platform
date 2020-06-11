package com.example.iot_rule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IotRuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotRuleApplication.class, args);
	}

}
