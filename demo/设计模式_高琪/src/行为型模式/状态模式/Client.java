package 行为型模式.状态模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        State state = new FreeState();
        Context context = new Context();
        context.setState(state);
    }
}
