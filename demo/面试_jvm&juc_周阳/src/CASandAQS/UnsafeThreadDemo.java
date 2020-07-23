package luban.bingfa.CASandAQS;

import java.util.concurrent.TimeUnit;
/**
 * 不安全的线程调用
 */
import static java.lang.System.out;

public class UnsafeThreadDemo {

    private int m = 0;

    public int add() {
        try {
            TimeUnit.SECONDS.sleep(2);
            m++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return m;
    }

    public static void main(String[] args) {
        UnsafeThreadDemo p = new UnsafeThreadDemo();
        Thread[] ts = new Thread[20];
        for (int i=0;i < 20;i++) {
            ts[i] = new Thread( () -> {
                out.println( p.add() );
            });
            ts[i].start();
        }
    }

}
