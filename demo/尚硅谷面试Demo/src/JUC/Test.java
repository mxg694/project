package JUC;

/**
 * author: mxg
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperties());
    }

    volatile int n = 1;

    public void add() {
        n++;
    }
}
