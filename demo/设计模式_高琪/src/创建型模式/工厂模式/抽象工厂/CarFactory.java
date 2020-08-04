package 创建型模式.工厂模式.抽象工厂;

/**
 * author: mxg
 */
public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre createTyre();
}
