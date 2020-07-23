package 行为型模式.策略模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Strategy s = new OldCustomerMany();
        Context context = new Context(s);
        context.pringPrice(100);
    }
}
