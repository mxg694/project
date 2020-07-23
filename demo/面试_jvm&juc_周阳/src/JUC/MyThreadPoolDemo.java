package JUC;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * author: mxg
 *
 * ThreadPoolExecutor
 *
 *
 *  public ThreadPoolExecutor(int corePoolSize,             核心线程数
 *                               int maximumPoolSize,       最大线程数
 *                               long keepAliveTime,       多余的空闲线程存活时间
 *                               TimeUnit unit,            keepAliveTime的单位
 *                               BlockingQueue<Runnable> workQueue,   阻塞队列
 *                               ThreadFactory threadFactory,         线程工厂 用默认
 *                               RejectedExecutionHandler handler) {  拒绝策略
 *
 *
 *  第四种获得、使用java多线程的方式  线程池
 *
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {

        // 一池五个处理线程  一个银行5个业务窗口
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //一池一线程
        ExecutorService threadPool1 = Executors.newSingleThreadExecutor();
        //一池多线程
        ExecutorService threadPool2 = Executors.newCachedThreadPool();

        try {
            //模拟10个用户来办理业务
            for (int i=0; i<10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
