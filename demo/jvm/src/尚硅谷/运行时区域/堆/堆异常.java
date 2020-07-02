package 尚硅谷.运行时区域.堆;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * -Xms400M  -Xmx400M
 */
public class 堆异常 {
    public static int count = 0;
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while (true) {
            list.add(new byte[1024*1024]);
        }
    }
}
