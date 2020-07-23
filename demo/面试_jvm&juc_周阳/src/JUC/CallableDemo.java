package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 * <p>
 * <p>
 * 两个线程  一个 main主线程  一个futureTask
 */
public class CallableDemo {

    public static void main(String[] args) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
        Integer integer = 0;
        Thread thread = new Thread(futureTask);
        thread.start();
//        integer = futureTask.get();


        while (futureTask.isDone()) {

        }


        System.out.println("===========main==========================");
        //要求获取 Callable 线程的计算结果，如果没有计算完成，会导致阻塞， 直到计算完成
        integer = futureTask.get();
        int result = 100;

        System.out.println("result:" + integer + "");
    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "coming in callanle");
        TimeUnit.SECONDS.sleep(5);
        return 1024;
    }
}