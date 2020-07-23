package JUC.队列;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 */
public class SynchronizedQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String > blockingQueue = new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t 进入队列"+ 1);
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t 进入队列"+ 2);
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t 进入队列"+ 3);
                blockingQueue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t 获取数据"+  blockingQueue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"\t 获取数据"+  blockingQueue.take());

                System.out.println(Thread.currentThread().getName()+"\t 获取数据"+  blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
