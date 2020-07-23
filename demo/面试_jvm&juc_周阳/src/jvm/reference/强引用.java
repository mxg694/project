package jvm.reference;

/**
 * author: mxg

 */
public class 强引用 {
    public static void main(String[] args) {
        //强引用
        Object o1 = new Object();
        //引用赋值
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o2);
    }
}
