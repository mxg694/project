package day1;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 * <p>
 * 强引用   软引用 弱引用  虚引用
 * 参数： -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class 四种引用 {
    private static final int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
//        强引用();
        System.out.println("===========================");
//        软引用();
        弱引用();
    }

    /**
     * 强引用 demo
     */
    public static void 强引用() throws Exception {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new byte[_4MB]);
        }

        System.in.read();
    }

    public static void 软引用() {

        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();

        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int  i=0; i<5; i++) {
           //关联了引用队列，当软引用锁关联的byte[]被回收，软引用会自己加入到queue中
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }

        System.out.println("-------引用队列------");
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null ) {
            list.remove(poll);
            poll = queue.poll();
        }

        System.out.println("--------------------------");
        System.out.println("循环结束：" + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.print(ref.get()+"===");
        }
    }

    public static void 弱引用() {

        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int  i=0; i<5; i++) {
            //关联了引用队列，当软引用锁关联的byte[]被回收，软引用会自己加入到queue中
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(i).get()+"->");
            }
        }

        System.out.println("引用循环结束：" + list.size());
        for (WeakReference<byte[]> ref : list) {
            System.out.print(ref.get()+"=>");
        }
    }
}
