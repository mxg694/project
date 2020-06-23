package JUC.锁;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author: mxg
 * <p>
 * 读读  共存
 * 读写  不能共存
 * 写写  不能共存
 */
public class 读写锁 {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    cache.write(finalI + "", finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    cache.get(finalI + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }


}

/**
 * 资源类
 * <p>
 * 写 + 读
 * 写操作： 整个过程必须是一个完整的统一体，中间不允许被分割，被打断
 */
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * @param key
     * @param val
     * @throws InterruptedException
     */
    public void write(String key, Object val) throws InterruptedException {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, val);
            System.out.println(Thread.currentThread().getName() + "\t写入完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }


    }

    /**
     * 读取
     *
     * @param key
     * @throws InterruptedException
     */
    public void get(String key) throws InterruptedException {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取" + key);
            TimeUnit.MILLISECONDS.sleep(300);
            Object val = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成" + key + "\t: value=" + val);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}