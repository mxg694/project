package 行为型模式.中介者模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Mediator m = new Manager();

        Market mt = new Market(m);
        Finaical f = new Finaical(m);
        mt.askRequest();
        m.command("Finaical");


    }
}
