package 创建型模式.工厂模式.抽象工厂;

/**
 * author: mxg
 */
public interface Engine {
    void run();
    void start();
}

class GoodEngine implements Engine {

    @Override
    public void run() {
        System.out.println("跑的快");
    }

    @Override
    public void start() {
        System.out.println("启动快");
    }
}

class LowEngine implements Engine {

    @Override
    public void run() {
        System.out.println("跑的慢");
    }

    @Override
    public void start() {
        System.out.println("跑的慢");
    }
}