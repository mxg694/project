package 行为型模式.策略模式;

/**
 * author: mxg
 * 负责和策略类交互
 *  把算法和直接的客户端分类
 *   算法独立于客户端
 */
public class Context {
    /**
     * 当前采用的算法对象
     *
     */
    private Strategy strategy;

    public void pringPrice(double s) {
        System.out.println("您的报价："+ strategy.getPrice(s));
    }








    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
