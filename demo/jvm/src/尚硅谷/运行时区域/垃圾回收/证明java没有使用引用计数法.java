package 尚硅谷.运行时区域.垃圾回收;

/**
 * author: mxg
  -XX:+PrintGCDetails
 */
public class 证明java没有使用引用计数法 {
    // 作用 占点内存
    private byte[] bigsize = new byte[5 * 1024 * 1024];
    Object reference = null;

    public static void main(String[] args) {
        证明java没有使用引用计数法 obj1 = new 证明java没有使用引用计数法();
        证明java没有使用引用计数法 obj2 = new 证明java没有使用引用计数法();
        obj1.reference = obj2;
        obj2.reference = obj1;
        obj1 = null;
        obj2 = null;

        //查看 obj1 和obj2能否被回收
        System.gc();
    }
}
