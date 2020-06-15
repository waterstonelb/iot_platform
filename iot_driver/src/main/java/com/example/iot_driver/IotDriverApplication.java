package com.example.iot_driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class IotDriverApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotDriverApplication.class, args);
	}

}
