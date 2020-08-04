package cn.it.注解.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * author: mxg
 */

public class MyFactoryBean implements FactoryBean<Factory> {
    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Factory getObject() throws Exception {
        System.out.println("MyFactoryBean...getObject...");
        return new Factory();
    }

    @Override
    public Class<?> getObjectType() {
        return Factory.class;
    }

    //true：这个bean是单实例，在容器中保存一份
    //false：多实例，每次获取都会创建一个新的bean；
    @Override
    public boolean isSingleton() {
        return true;
    }
}
