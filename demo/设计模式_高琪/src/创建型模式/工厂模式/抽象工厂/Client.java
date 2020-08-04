package 创建型模式.工厂模式.抽象工厂;

/**
 * author: mxg
 */
public class Client {
    public static void main(String[] args) {
        CarFactory factory = new GoodCarFactory();
        Engine engine = factory.createEngine();
        engine.run();
        engine.start();
    }
}
