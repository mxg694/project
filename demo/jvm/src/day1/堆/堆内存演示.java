package day1.堆;

import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 */
public class 堆内存演示 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1111111");
        TimeUnit.SECONDS.sleep(30);
        byte[] array = new byte[1024*1024*10];
        System.out.println("2**************");
        TimeUnit.SECONDS.sleep(30);
        array = null;
        System.gc();
        System.out.println("3--------------------------");
        TimeUnit.SECONDS.sleep(30);

    }
}
