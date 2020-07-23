package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: mxg
 *
 * 一个初始值为0 的变量，两个线程对其交替操作，一个加1 一个减 1，五轮
 *
 *  1.线程     操作     资源类
 *  2.判断      干活    通知
 *  3.防止虚假唤醒机制
 *
 *  多线程判断要用while
 */
public class 生产者消费者_traditiion {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        for (int i=0; i<5; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"t1").start();
        }

        for (int i=0; i<5; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"t2").start();
        }

        for (int i=0; i<5; i++) {
            new Thread(()->{
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"t3").start();
        }

        for (int i=0; i<5; i++) {
            new Thread(()->{
                try {
                    shareData.decrement();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            },"t4").start();
        }

    }
}


class ShareData{
    private int number  =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void increment() throws  Exception {
        lock.lock();
        try {
            //判断
            while (number != 0) {
                //等待，
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t " + number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws  Exception {
        lock.lock();
        try {
            //判断
            while (number == 0) {
                //等待，
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t " + number);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}