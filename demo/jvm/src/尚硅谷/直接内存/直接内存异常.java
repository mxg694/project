package 尚硅谷.直接内存;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * author: mxg
 *
 java.lang.OutOfMemoryError: Direct buffer memory

 -Xmx20m
 -XX:maxDirectMemorySize=10m   设置直接内存的大小 默认和堆的最大内存一致
 *
 */
public class 直接内存异常 {
    private static int Buffer = 1024*1024 *24; //24m

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int count = 0;
        try {
         while (true) {
             ByteBuffer byteBuffer = ByteBuffer.allocateDirect(Buffer);
             list.add(byteBuffer);
             count++;
         }

        } finally {
            System.out.println(count);
        }


    }
}
