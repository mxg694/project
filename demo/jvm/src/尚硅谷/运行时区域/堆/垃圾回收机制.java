package 尚硅谷.运行时区域.堆;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 *
 参数： -Xms9M -Xmx9M -XX:+PrintGCDetails
 * 测试
 * MinorGc:
 * majorGc:
 * fullGc:
 */
public class 垃圾回收机制 {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "aaaaaaaaa";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Exception e) {
            System.out.printf("i的值：" + i);
            e.printStackTrace();
        }
    }
}
