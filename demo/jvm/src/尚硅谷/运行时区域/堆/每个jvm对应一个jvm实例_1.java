package 尚硅谷.运行时区域.堆;

import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 *
 *  -Xms10M  -Xmx10M   堆起始大小和最大大小
 */
public class 每个jvm对应一个jvm实例_1 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("每个jvm对应一个jvm实例_1 start");
        TimeUnit.SECONDS.sleep(1000);
        System.out.println("每个jvm对应一个jvm实例_1 end");
    }
}
