package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * java.lang.OutOfMemoryError: GC overhead limit exceeded
  超过98%的系统资源来做GC，只回收了不到2%的内存
  GC 时间过长
 */
public class GcOverheadlimitExceededError {
    public static void main(String[] args) {
        int i=0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i));
            }
        } catch (Throwable e) {
            System.out.println("===========：" +i);
            e.printStackTrace();
        }
    }

}
