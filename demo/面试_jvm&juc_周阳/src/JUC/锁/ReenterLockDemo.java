package JUC.锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: mxg
 *  可重入锁
 *      同一个线程 在外层方法中获取锁之后，在进入内层方法会自动获取锁
 *
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            phone.sendSms();
        },"t1").start();
        new Thread(()->{
            phone.sendSms();
        },"t2").start();
    }
}


class Phone {
    Lock lock = new ReentrantLock();
    public synchronized  void  sendSms() {
        System.out.println(Thread.currentThread().getName() +"\t invoked sendSMS" );
        sendEmail();
    }

    public synchronized void  sendEmail() {
        System.out.println(Thread.currentThread().getName()+"\t ###### invoked sendEmail");
    }

    public void  run() {

        get();
    }

    private void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"\t invoked get()" );
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"\t #######invoked set()" );
        }finally {
            lock.unlock();
        }
    }

}