package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: mxg
 * 多线程之间按顺序调用  实现 A->B->C 是哪个线程启动，要求如下
 *  AA 打印5次 BB打印10次  CC打印 15次
 *  然后
 *  AA 打印5次 BB打印10次  CC打印 15次
 *  以此类推
 */
public class 锁绑定多个条件condition {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        for (int i=0; i<3; i++) {
            new Thread(()->{
                shareResource.print5();
            },"A").start();
        }

        for (int i=0; i<3; i++) {
            new Thread(()->{
                shareResource.print10();
            },"B").start();
        }

        for (int i=0; i<3; i++) {
            new Thread(()->{
                shareResource.print15();
            },"C").start();
        }
    }

}

class ShareResource{
    private int number =1;  //1 A  2 B  c  3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number !=1) {
               c1.await();
            }
            for (int i=1; i<=5;i++) {
                System.out.println(Thread.currentThread().getName()+"\t :" +i );
            }
           //通知
            number++;
            c2.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10() {
        lock.lock();
        try {
            while (number !=2) {
                c2.await();
            }
            for (int i=1; i<=5;i++) {
                System.out.println(Thread.currentThread().getName()+"\t :" +i );
            }
            //通知
            number++;
            c3.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void print15() {
        lock.lock();
        try {
            while (number !=3) {
                c3.await();
            }
            for (int i=1; i<=5;i++) {
                System.out.println(Thread.currentThread().getName()+"\t :" +i );
            }
            //通知
            number=1;
            c1.signal();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
