package 创建型模式.工厂模式.抽象工厂;

/**
 * author: mxg
 */
public interface Tyre {
    void revolve();
}

class GoodTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("高端轮胎");
    }
}

class LowTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("低端轮胎");
    }
}