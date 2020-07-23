package JUC.锁;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {

    }

    public static void countDownLatchDemo () throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i=1; i<= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 离开教室");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 最后一个离开，检查走人");
    }
}
