package 行为型模式.命令模式;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver =new Receiver();
        Command command =new ConcreteCommand(receiver);

        Invoke invoke = new Invoke(command);
        invoke.call();
    }
}
