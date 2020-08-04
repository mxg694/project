package 创建型模式.工厂模式.抽象工厂;

/**
 * author: mxg
 */
public interface Seat {
    void massage();
}

class GoodSeat implements Seat {

    @Override
    public void massage() {
        System.out.println("可以按摩");
    }
}

class LowSeat implements Seat {

    @Override
    public void massage() {
        System.out.println("不可以按摩");
    }
}