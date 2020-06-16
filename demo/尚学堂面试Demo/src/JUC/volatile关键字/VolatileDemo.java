package JUC.volatile关键字;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: mxg
 * <p>
 * 验证volatile 可见性
 * <p>
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {
        volatile_原子性();
    }


    public static void volatile_原子性() {
        MyData myData = new MyData();
        for (int i =0 ;i < 10; i++) {
            new Thread(()->{
                for (int j =0 ;j < 1000; j++) {
                    myData.add();
                    myData.addAutomic();
                }

            }, String.valueOf(i)).start();
        }
        //默认 一个 gc线程 一个 main 线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" \t int type finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName()+" \t AutomicInteger type finally number value:" + myData.atomicInteger);
    }

    /**
     * 测试 volatile 的 可见性
     */
    public static void volatile_可见性() {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update " + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            //
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over  main get number " + myData.number );
    }
}


class MyData {
    //  int number = 0;
    volatile int number = 0;

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAutomic() {
        atomicInteger.getAndIncrement();
    }

    public void addTo60() {
        number = 60;
    }

    /**
     *  number 是加了 volatile 关键字的
     */
    public void add() {
       number++;
    }
}