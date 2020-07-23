package 行为型模式.中介者模式;

/**
 * author: mxg
 */
public class Development implements Department {
   private Mediator m; //持有中介者的引用

    public Development(Mediator m) {
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void doself() {
        System.out.println("研发部：专心研发");
    }

    @Override
    public void askRequest() {
        System.out.println("研发部，缺钱");
    }
}
