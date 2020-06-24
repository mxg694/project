package 尚硅谷.运行时区域.虚拟机栈;

import java.util.Date;

/**
 * author: mxg
 */
public class 局部变量表 {

    private int count = 0;

    public static void main(String[] args) {
        局部变量表 test = new 局部变量表();
        test.m1();
    }

    public 局部变量表() {

    }

    public static void test() {
        局部变量表 test = new 局部变量表();
        Date d = new Date();
        String a = "aa";
        String b = new String("aa");
        Long l = 1L;
        int c = 2;
    }

    public void m1() {
        int i = 1;
        int b = 2;
        Date d = m2();
    }

    public Date m2() {
        Date d = new Date();
        String s = "aaa";
        return d;
    }
}
