package cn.it.app.controller;

import cn.it.api.ApiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class ApplicationController {

    //注入service 基于dubbo协议
//    @org.apache.dubbo.config.annotation.Reference
//    private ApiService apiService;

    @GetMapping("/self")
    public String self() {
        System.out.println("app-self");
        return "app-1";
    }

//    @GetMapping("/service")
//    public String service() {
//        String service = apiService.service();
//        return "test" + service;
//    }
}
