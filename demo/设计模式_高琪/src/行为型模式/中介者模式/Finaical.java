package 行为型模式.中介者模式;

/**
 * author: mxg
 */
public class Finaical implements Department {
   private Mediator m; //持有中介者的引用

    public Finaical(Mediator m) {
        this.m = m;
        m.register("Finaical",this);
    }

    @Override
    public void doself() {
        System.out.println("财务部：发钱发钱");
    }

    @Override
    public void askRequest() {
        System.out.println("财务部，花钱");
    }
}
