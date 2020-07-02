package 尚硅谷.运行时区域.垃圾回收;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 */
public class StopTheWorldDemo {
    public static void main(String[] args) {
        WorkThread w = new WorkThread();
        PrintThread p = new PrintThread();
        w.start();
        p.start();
    }

    public static class WorkThread extends Thread {
        List<byte[]> list = new ArrayList<>();

        @Override
        public void run() {
            try {
                while (true) {
                    for (int i = 0; i <1000 ; i++) {
                        byte[] b = new byte[1024];
                        list.add(b);
                    }
                    if (list.size()>10000) {
                        list.clear();
                        System.gc();  //会触发 full gc  触发 stw
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintThread extends Thread {
        public final long startTime = System.currentTimeMillis();

        @Override
        public void run() {
            while (true) {
                try {
                    //每秒打印时间信息
                    long t = System.currentTimeMillis() - startTime;
                    System.out.println(t/1000+"." + t%1000);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
