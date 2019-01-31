package com.example.logservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LoggingServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(LoggingServiceApp.class, args);
    }

}
