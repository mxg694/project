package 尚硅谷.Four引用;

import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 */
public class 强引用 {
    public static void main(String[] args) throws InterruptedException {
        StringBuilder str = new StringBuilder("hello");
        StringBuilder str1 = str;

        str = null;
        System.gc();

        TimeUnit.SECONDS.sleep(3);

        System.out.println(str1);  //hello
    }
}
