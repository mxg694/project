package com.lubn.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@RestController
public class PowerController {


    @RequestMapping("/getPower.do")
    public Object getPoser(String name) throws Exception{
        Map<String,Object> map = new HashMap<>();
        map.put("key","power");

        //测试 服务器出问题
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException();
        }
        //测试 接口超时
        Thread.sleep(2000);

        return map;
    }

}
