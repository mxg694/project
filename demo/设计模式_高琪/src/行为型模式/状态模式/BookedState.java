package 行为型模式.状态模式;

/**
 * author: mxg
 *  房间预订
 */
public class BookedState implements State{
    @Override
    public void handle() {
        System.out.println("房间被预订");
    }
}
