package 尚硅谷.Four引用;

import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * author: mxg
 */
public class 弱引用 {
    public static void main(String[] args) throws InterruptedException {
/*        Sf sf = new Sf("a");
        WeakReference<Sf> wr = new WeakReference(sf);
        sf = null;*/
        WeakReference<Sf> wr = new WeakReference<>(new Sf("a"));
        System.out.println("内存足够：" + wr.get());
        System.gc();
//        TimeUnit.SECONDS.sleep(3);
        System.out.println("垃圾回收后：" + wr.get());
    }
}
