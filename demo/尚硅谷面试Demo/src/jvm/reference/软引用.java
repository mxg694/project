package jvm.reference;

import java.lang.ref.SoftReference;

/**
 * author: mxg
 */
public class 软引用 {
    public static void main(String[] args) {
//        内存够_不回收();
        内存不够_回收();
    }

    public static void 内存够_不回收() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void 内存不够_回收() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;

        try {
            byte[] bytes = new byte[30*1024*1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("o1:" +o1);
            System.out.println("softReference:"  + softReference.get());
        }
    }
}


