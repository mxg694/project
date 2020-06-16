package JUC.volatile关键字;

/**
 * author: mxg
 */
public class Test {
    volatile int n = 1;

    public void add() {
        n++;
    }
}
