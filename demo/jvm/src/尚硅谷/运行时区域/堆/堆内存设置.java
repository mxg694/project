package 尚硅谷.运行时区域.堆;

/**
 * author: mxg
 *      -Xms:
 *      -X: jvm的运行参数
 *      ms: memory start
 *
        -Xmx: 设置堆空间（年轻代+老年代）的最大内存大小
    默认堆空间大小：
        初始内存大小：物理内存大小/64
        最大内存大小：物理内存大小/4
    手动设置：
        建议将初始值和最大值设为同一个值
        -Xms10M  -Xmx10M

    查看设置方式：
      一：  jps    获取端口号 ， jstat -gc 端口号
      二:   -XX:+PringGCDetails   打印GC信息



 */
public class 堆内存设置 {

    public static void main(String[] args) {
        //java 虚拟机中的内存总量信息
        Long initialMemory = Runtime.getRuntime().totalMemory()/1024/1024;
        // java虚拟中最大的堆内存量
        Long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;

        System.out.println("-Xms:" + initialMemory + "m");
        System.out.println("-Xmx:" + maxMemory + "M");


        System.out.println("系统内存大小为："+initialMemory*64.0/1024+"G");
        System.out.println("系统内存大小为："+maxMemory*4.0/1024+"G");

    }
}
