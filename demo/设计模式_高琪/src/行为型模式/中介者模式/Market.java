package 行为型模式.中介者模式;

/**
 * author: mxg
 */
public class Market implements Department {
   private Mediator m; //持有中介者的引用

    public Market(Mediator m) {
        this.m = m;
        m.register("Market",this);
    }

    @Override
    public void doself() {
        System.out.println("市场部 缺钱");
    }

    @Override
    public void askRequest() {
        System.out.println("市场部，要钱");
    }
}
