package 结构型模式.代理模式.静态代理;

/**
 * author: mxg
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void pre() {
        System.out.printf("proxyStar 前置操作");
    }

    @Override
    public void dosomething() {
      star.dosomething();
    }

    @Override
    public void post() {
        System.out.printf("proxyStar 后置操作");
    }
}
