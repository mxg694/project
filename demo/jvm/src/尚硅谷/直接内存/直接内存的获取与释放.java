package 尚硅谷.直接内存;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * author: mxg
 */
public class 直接内存的获取与释放 {

    private static int Buffer = 1024*1024 *1024; //1G

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(Buffer);
        System.out.println("直接内存分配完毕，请求指示");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("直接内存开始释放");
        byteBuffer = null;
        System.gc();
        scanner.next();

    }
}
