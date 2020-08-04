package cn.it.consumer.controller;

import cn.it.consumer.feign.ProviderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class ConsumerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/service")
    public String service() {
        LOGGER.info("consumer invoke");
        String service = providerClient.service();
        return "comsumer invoke" + "|" + service;
    }
}

