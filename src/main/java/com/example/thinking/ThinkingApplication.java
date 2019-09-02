package com.example.thinking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * springboot引导类
 */
@RestController
@SpringBootApplication
public class ThinkingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ThinkingApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "hello springboot thinking";
	}

}
