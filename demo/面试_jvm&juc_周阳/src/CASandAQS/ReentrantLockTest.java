package luban.bingfa.CASandAQS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockTest {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private int m  =0 ;
    public void a() {
        reentrantLock.lock();
        System.out.println("a");
        b();
        reentrantLock.unlock();
    }

    public void b() {
        reentrantLock.lock();
        System.out.println("b");
        reentrantLock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(()-> {
            test.a();
        }).start();
    }
}
