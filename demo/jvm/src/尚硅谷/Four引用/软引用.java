package 尚硅谷.Four引用;

import java.lang.ref.SoftReference;

/**
 * author: mxg
 * <p>
 * 内存不足，即回收
 */
public class 软引用 {
    public static void main(String[] args) {
        Object obj = new Object();
        /**
         *   等价于
         *    Sf obj = new Sf("Sf");
         *    SoftReference<Sf> sf = new SoftReference<Sf>(obj);
         *    obj1 = null;
         */
        SoftReference<Object> sf = new SoftReference<Object>(new Sf("sf"));
        //从软引用中重新获得引用对象
        System.out.println(sf.get());

        System.gc();
        //内存任然够
        System.out.println("After GC:" + sf.get());

        try {
            //让系统认为内存资源不足
            byte[] b = new byte[1024 * 1024 * 7];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            //内存不够
            System.out.println("内存不够:" + sf.get());
        }
    }
}

class Sf{
    private String name;

    public Sf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Sf{" +
                "name='" + name + '\'' +
                '}';
    }
}