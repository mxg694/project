package 创建型模式.单例设计.懒汉式;

/**
 * author: mxg
 */
public class 懒汉式_方法中锁代码块 {

}

class Singleton_MethodLockBlock {

    private static Singleton_MethodLockBlock instance;

    private Singleton_MethodLockBlock() {
    }

    public static Singleton_MethodLockBlock getInstance() {
        //可能产生线程不安全
        if(instance == null) {
            synchronized (Singleton_MethodLockBlock.class) {
                instance = new Singleton_MethodLockBlock();
            }
        }
        return instance;
    }
}