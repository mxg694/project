package JUC;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: mxg
 *
 *
 */
public class 生产者消费者_BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
        MyResource myResource = new MyResource(arrayBlockingQueue);

        new Thread(()->{
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(()->{
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();


        new Thread(()->{
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod1").start();

        new Thread(()->{
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer1").start();


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        TimeUnit.SECONDS.sleep(15);
        System.out.println("大老板叫停，活动结束" );
        myResource.stop();

    }
}

class MyResource {
    //默认开启 进行生产+ 消费
    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String > blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retval ;
        while (FLAG) {
            data = atomicInteger.incrementAndGet()+"";
            retval = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retval) {
                System.out.println(Thread.currentThread().getName()+"\t 插入数据"+data+"成功" );
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入数据"+data+"失败" );
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"\t 生产结束");
    }

    public void myConsumer() throws Exception {
        String res = null;
        while (FLAG) {
            res = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null == res || res.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println();
                System.out.println();
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没取到数据，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+res+"成功");
        }
    }

    public void stop() {
        FLAG =false;
    }
}