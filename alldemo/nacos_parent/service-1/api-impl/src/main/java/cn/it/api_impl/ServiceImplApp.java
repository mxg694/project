package cn.it.api_impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceImplApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceImplApp.class, args);
    }
}
