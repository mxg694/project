package cn.it.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }


//    @Autowired
//    ConfigurableApplicationContext context;
//
//    @Value("${common.name}")
//    private String config;
//
//    @GetMapping("config")
//    public String getConfig() {
//        return config;
//    }
//
//    @GetMapping("config2")
//    public String getConfig2() {
//        return context.getEnvironment().getProperty("common.name");
//    }


}
