package 尚硅谷.运行时区域.堆;

import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 * -Xms20M  -Xmx20M   堆起始大小和最大大小
 *  -XX:+PrintGCDetails   打印GC信息
 *
 * 使用 jdk中的 jvisualvm工具 查看
 */
public class 每个jvm对应一个jvm实例_2 {
    public static void main(String[] args) {
        System.out.println("每个jvm对应一个jvm实例_2 start");
        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("每个jvm对应一个jvm实例_2 end");
    }

}
