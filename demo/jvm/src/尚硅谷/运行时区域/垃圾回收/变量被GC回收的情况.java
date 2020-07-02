package 尚硅谷.运行时区域.垃圾回收;

/**
 * author: mxg
 * 查看变量是否会把GC 回收
 * -XX:+PrintGCDetails
 */
public class 变量被GC回收的情况 {
    public static void main(String[] args) {
        变量被GC回收的情况 m = new 变量被GC回收的情况();

        m.m5();
    }

    /**
     * 没有回收
     */
    public void m1() {
        byte[] b = new byte[10 * 1024 * 1024];
        System.gc();
    }

    /**
     * 回收掉了
     */
    public void m2() {
        byte[] b = new byte[10 * 1024 * 1024];
        b = null;
        System.gc();
    }

    /**
     * 没有回收
     */
    public void m3() {
        {
            byte[] b = new byte[10 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * 回收了
     */
    public void m4() {
        {
            byte[] b = new byte[10 * 1024 * 1024];
        }
        int tt = 1;
        System.gc();
    }

    public void m5() {
        m1();
        System.gc();
    }
}
