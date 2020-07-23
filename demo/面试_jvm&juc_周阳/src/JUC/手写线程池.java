package JUC;

import java.util.concurrent.*;

/**
 * author: mxg
 * <p>
 * <p>
 * 手写线程池和拒绝策略
 * ThreadPoolExecutor.AbortPolicy()
 * ThreadPoolExecutor.CallerRunsPolicy()
 * ThreadPoolExecutor.DiscardOldestPolicy()
 * ThreadPoolExecutor.DiscardPolicy()
 */
public class 手写线程池 {

    public static void main(String[] args) {
        //CPU核心线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(2
                , 5
                , 1L
                , TimeUnit.SECONDS
                , new LinkedBlockingQueue<>(3)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());


        try {
            //模拟10个用户来办理业务
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
