package day2.垃圾回收;

import java.util.ArrayList;

/**
 * author: mxg
  堆初始大小20- 最大20m - 新生代-10    打印gc信息
  -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc -XX:-ScavengeBeforeFullGC
 */
public class 演示内存的分配策略 {
    private static final int _512KB = 512 * 1024;
    private static final int _1MB = 1024 * 1024;
    private static final int _6MB = 6 * 1024 * 1024;
    private static final int _7MB = 7 * 1024 * 1024;
    private static final int _8MB = 8 * 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {

    }

    public static void toeden区() {
        ArrayList<byte[]> list = new ArrayList<>();
        //会触发一次 Mgc 然后把数据放入到eden区 和  to区
        list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);
    }

    /**
     * 大对象直接进入老年代
     */
    public static void to老年代区() {
        ArrayList<byte[]> list = new ArrayList<>();
        //会触发一次 Mgc 然后把数据放入到eden区 和  to区
        list.add(new byte[_8MB]);
    }

    /**
     * 某个线程的内存溢出 有时候不会影响到主线程的进行
     * @throws InterruptedException
     */
    public static void  threadInfo() throws InterruptedException {
        new Thread(() -> {
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();

        System.out.println("sleep....");
        Thread.sleep(1000L);
    }
}
