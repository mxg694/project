package 结构型模式.代理模式.动态代理;

import java.lang.reflect.Proxy;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        proxy.dosomething();

    }
}
