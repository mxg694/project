package JUC.锁;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 *
 *  信号灯  抢停车位  多个线程抢多个停车位
 *   代替 synchronized
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 3个停车位
        Semaphore semaphore = new Semaphore(3);
        //6个汽车
        for (int i=1; i< 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\t 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
