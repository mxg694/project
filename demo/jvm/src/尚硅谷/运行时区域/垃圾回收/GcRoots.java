package 尚硅谷.运行时区域.垃圾回收;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * author: mxg

 通过  jvisualvm.exe   把数据dump到文件
 利用  mat   内存消耗的情况

 */
public class GcRoots {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        Date birth = new Date();

        for (int i = 0; i < 100; i++) {
            list.add(i);
            TimeUnit.MILLISECONDS.sleep(10);
        }

        System.out.println("数据加载完毕，请操作");
        //第一次dump数据
        new Scanner(System.in).next();
        list = null;
        birth= null;
        System.out.println("置空数据，请操作");
        //第二次dump数据
        new Scanner(System.in).next();
        System.out.println("结束");

    }
}
