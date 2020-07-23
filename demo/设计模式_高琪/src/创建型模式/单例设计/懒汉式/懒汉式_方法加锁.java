package 创建型模式.单例设计.懒汉式;

/**
 * author: mxg
 */
public class 懒汉式_方法加锁 {
}

class Singleton_LockMethod {

    private static Singleton_LockMethod instance;

    private Singleton_LockMethod() {
    }

    public static synchronized Singleton_LockMethod getInstance() {
        if(instance == null) {
            instance = new Singleton_LockMethod();
        }
        return instance;
    }
}