package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(scanBasePackages = {"com.example.demospringboot"})
@EnableJpaRepositories("com.example.demo")
@ComponentScan("com.example")
public class DemoApplication {
    public static void main(String[] args) {
    	
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
