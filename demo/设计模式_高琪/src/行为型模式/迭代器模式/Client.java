package 行为型模式.迭代器模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate ca = new ConcreteMyAggregate();
        ca.getList().add("a");
        ca.getList().add("b");
        ca.getList().add("c");

        MyIterator ite = ca.createMyIterator();
        while (ite.hasNext()) {
            System.out.println(ite.getCurrentObj());
            ite.next();
        }
    }
}
