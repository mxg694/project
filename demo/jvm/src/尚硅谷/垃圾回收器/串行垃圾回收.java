package 尚硅谷.垃圾回收器;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
  author: mxg
  -XX:+PrintCommandLineFlags
  -XX:+UseSerialGC  使用串行GC
  新生代使用： Serial GC  老年代使用 Serial Old GC
  <p>
  -XX:+UseParNewGC  使用 parNew 垃圾收集器
  -XX:ParallelGCThreads 限制线程数量，默认和cpu相同核数
  <p>
  XX:+UseConcMarkSweepGC  老年代使用cmsGC ，年轻代使用 parNew GC
  <p>
  -XX:+UseParallelGC    新生代使用 ParallelGC
  -XX:+UseParallelOldGC    老年代使用 Parallel Old GC
 */
public class 串行垃圾回收 {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
