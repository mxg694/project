package 行为型模式.状态模式;

/**
 * author: mxg
 */
public class CheckedState implements State {
    @Override
    public void handle() {
        System.out.println("房间已入住");
    }
}
