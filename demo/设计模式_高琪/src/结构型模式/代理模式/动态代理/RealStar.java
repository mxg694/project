package 结构型模式.代理模式.动态代理;

/**
 * author: mxg
 */
public class RealStar implements Star {
    @Override
    public void pre() {
        System.out.println("realStar 前置操作");
    }

    @Override
    public void dosomething() {
        System.out.println("realStar 核心业务");
    }

    @Override
    public void post() {
        System.out.println("realStar 后置操作");
    }
}
