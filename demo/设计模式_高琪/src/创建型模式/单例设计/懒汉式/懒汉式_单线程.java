package 创建型模式.单例设计.懒汉式;

/**
 * author: mxg
 */
public class 懒汉式_单线程 {

}

class Singleton_SingleThread {

    private static Singleton_SingleThread instance;

    private Singleton_SingleThread() {
    }

    public static Singleton_SingleThread getInstance() {
        if(instance == null) {
            instance = new Singleton_SingleThread();
        }
        return instance;
    }
}