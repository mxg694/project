package 创建型模式.单例设计;

/**
 * author: mxg
 */
public class 双重检查 {
}

class Singleton_DCL {

    private static volatile Singleton_DCL instance;

    private Singleton_DCL() {
    }

    public static Singleton_DCL getInstance() {
        if(instance == null) {
            synchronized (Singleton_DCL.class) {
                if (instance == null) {
                    instance = new Singleton_DCL();
                }
            }

        }
        return instance;
    }
}

