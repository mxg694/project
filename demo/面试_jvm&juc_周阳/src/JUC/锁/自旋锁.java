package JUC.锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * author: mxg
 */
public class 自旋锁 {

    public static void main(String[] args) throws InterruptedException {
        自旋锁 myLock = new 自旋锁();

        new Thread(()->{
            myLock.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myLock.myUnlock();
        },"aa").start();

//        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            myLock.myLock();
            myLock.myUnlock();
        },"bb").start();
    }

    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        System.out.println(Thread.currentThread().getName() +"\t  come in ");
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null,thread)) {
            System.out.println(Thread.currentThread().getName() +"\t  自旋 ");
        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);

        System.out.println(Thread.currentThread().getName() +"\t  invoked  myUnlock ");
    }

}
