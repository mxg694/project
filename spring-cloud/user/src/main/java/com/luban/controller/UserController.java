package com.luban.controller;

import com.luban.service.PowerFeignClient;
import com.luban.util.R;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    private static final String  POWER_URL="http://SERVER-POWER";
    private static final String  ORDER_URL="http://SERVER-ORDER";

    @Autowired
    private  PowerFeignClient powerFeignClient;


    @RequestMapping("/getUser.do")

    public R getUser(){
        Map<String,Object> map = new HashMap<>();
        map.put("key","user");

        return R.success("返回成功",map);
    }

    @RequestMapping("/getOrder.do")
    public R getOrder(){
        return R.success("操作成功",restTemplate.getForObject(ORDER_URL+"/getOrder.do",Object.class));
    }

    /**
     * 测试服务器 熔断 超时
     * @return
     */
    @RequestMapping("/getFeignPower.do")
    @HystrixCommand(fallbackMethod="getFeignPowerFullBack")
    public R getFeignPower(){

        return R.success("操作成功",powerFeignClient.getPower());
    }

    @RequestMapping("/getPower.do")
    public R getPower(){
        return R.success("操作成功",restTemplate.getForObject(POWER_URL+"/getPower.do",Object.class));
    }

    /**
     * 服务器熔断 ，超时 之后调用的方法
     * @return
     */
    public R  getFeignPowerFullBack(){
        return R.error("系统正在维护中,请稍后重试");
    }
}
