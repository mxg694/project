package 尚硅谷.运行时区域.虚拟机栈;

/**
 * author: mxg
 */
public class 栈帧demo {
    public static void main(String[] args) {
        栈帧demo t = new 栈帧demo();
        t.m1();
    }

    public void m1() {
        System.out.println("m1()开始执行");
        m2();
        System.out.println("m1()执行结束");
    }

    public int m2() {
        System.out.println("m2()开始执行");
        int t = m3().intValue();
        System.out.println("m2()即将结束");
        return t;
    }

    public Double m3() {
        System.out.println("m3()开始执行");
        double t = 10D;
        System.out.println("m3()即将结束");
        return t;
    }

}
