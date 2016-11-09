package com.cloud.hashmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CustomhashmapApplication {

	@Bean
    public Cloud cloud() {
        return new CloudFactory().getCloud();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(CustomhashmapApplication.class, args);
	}
}
