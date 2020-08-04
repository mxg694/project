package 行为型模式.状态模式;

/**
 * author: mxg
 *  银行系统， context 就是账号， 金额不同，切换不同的状态
 *
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
        state.handle();
    }
}
