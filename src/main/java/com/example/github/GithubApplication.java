package com.example.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GithubApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubApplication.class, args);
	}

}
