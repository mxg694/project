package 结构型模式.代理模式.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author: mxg
 */
public class StarHandler implements InvocationHandler {

    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("前置方法");
        if (method.getName().equals("dosomething")) {
            method.invoke(realStar, args);
        }
        System.out.println("后置方法");
        return null;
    }
}
