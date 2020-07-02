package 尚硅谷.Four引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * author: mxg
 */
public class 虚引用 {
    /**
     * 当前类对象的声明
     */
    public static 虚引用 obj;
    /**
     * 虚引用队列
     */
    static ReferenceQueue<虚引用> queue= null;

    public static void main(String[] args) {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        queue = new ReferenceQueue<>();
        obj = new 虚引用();
        PhantomReference<虚引用> prf = new PhantomReference<>(obj, queue);
        try {
            //虚引用中的对象获取不到
            System.out.println(prf.get());
            obj = null;
            //第一次Gc， 由于对象可以复活，Gc无法回收改垃圾
            System.gc();
            Thread.sleep(1000);

            if (obj == null) {
                System.out.println("obj 是 null");
            }else {
                System.out.println("obj 可用");
            }
            System.out.println("第二次 Gc");
            obj = null;
            System.gc(); //一旦将obj对象回收，就会将此虚引用存放到引用队列
            Thread.sleep(1000);
            if (obj == null) {
                System.out.println("obj 是 null");
            }else {
                System.out.println("obj 可用");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


    public static class CheckRefQueue extends Thread{
        @Override
        public void run() {
            while (true) {
                if (queue != null) {
                    PhantomReference<虚引用> objt = null;
                    try {
                        objt = (PhantomReference<虚引用> )queue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (objt !=null) {
                        System.out.println("追踪垃圾回收过程， 虚引用 实例被Gc 了");
                    }
                }
            }
        }
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("调用当前类的finalize()");
        obj = this;
    }
}
