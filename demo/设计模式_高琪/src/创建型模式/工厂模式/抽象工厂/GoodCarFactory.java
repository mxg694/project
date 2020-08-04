package 创建型模式.工厂模式.抽象工厂;

/**
 * author: mxg
 */
public class GoodCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new GoodEngine();
    }

    @Override
    public Seat createSeat() {
        return new GoodSeat();
    }

    @Override
    public Tyre createTyre() {
        return new GoodTyre();
    }
}
