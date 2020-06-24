package 尚硅谷.运行时区域.虚拟机栈;

/**
 * author: mxg
 * 演示栈的异常
 * <p>
 * java.lang.StackOverflowError
 * -Xss: 设置栈大小
 * <p>
 * 默认情况下 ：count: 11409
 * 设置栈大小： -Xss256k : count: 2457
 */
public class 栈异常_设置栈大小 {
    private static int count = 0;

    public static void main(String[] args) {
        count++;
        System.out.println(count);
        main(args);
    }
}
