package cn.it.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: mxg
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@RequestMapping("user")
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
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
