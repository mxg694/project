package 尚硅谷.运行时区域.stringtable常量池;


/**
 * author: mxg
 */

public class demo {

    public static void main(String[] args) {
        t2();
    }

    public void test1() {
        String s1 = "a" + "b" + "c";
        String s2 = "abc"; //字面量  字符串常量赋值

        System.out.println(s1 == s2);  //true
        System.out.println(s1.equals(s2)); //true
    }

    public static void t2() {

        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";  //编译器优化
        //如果拼接符号前后出现了变量，则相当于在堆空间 new String()
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);  //true
        System.out.println(s3 == s5);  //false
        System.out.println(s3 == s6);  //false
        System.out.println(s3 == s7);  //false
        System.out.println(s5 == s6);  //false
        System.out.println(s5 == s7);  //false
        System.out.println(s6 == s7);  //false
    }

    public void t3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = s1 + s2;
        String s4 = "ab";
        System.out.println(s3 == s4);
    }

    public void t4() {
        final String s1 = "a";  //非变量
        final String s2 = "b";
        final String s3 = "ab";
        final String s4 = s1 + s2;
        System.out.println(s3 == s4); //true
    }
}
