package 行为型模式.状态模式;

/**
 * author: mxg
 *
 * 空闲状态
 *
 */
public class FreeState implements State{

    @Override
    public void handle() {
        System.out.println("房间空闲");
    }
}
