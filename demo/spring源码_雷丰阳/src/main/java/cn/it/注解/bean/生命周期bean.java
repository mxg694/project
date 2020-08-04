package cn.it.注解.bean;

import org.springframework.stereotype.Component;

/**
 * author: mxg
 */
@Component
public class 生命周期bean {
    public 生命周期bean(){
        System.out.println("生命周期bean constructor...");
    }

    public void init(){
        System.out.println("生命周期bean ... init...");
    }

    public void detory(){
        System.out.println("生命周期bean ... detory...");
    }
}
