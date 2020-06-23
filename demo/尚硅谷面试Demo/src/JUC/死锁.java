package JUC;

import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 */
public class 死锁 {
    public static void main(String[] args) {
        String lockA = "AAA";
        String lockB = "BBB";
        HoldLockThread h = new HoldLockThread(lockA, lockB);
        new Thread( new HoldLockThread(lockA, lockB),"AAA").start();
        new Thread( new HoldLockThread(lockB, lockA),"BBB").start();
    }
}

class HoldLockThread implements Runnable{

    private String lockA;
    private String lockB;


    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockA+"\t尝试获取" +lockB );
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 自己持有："+lockB+"\t尝试获取" +lockA );
            }
        }
    }
}