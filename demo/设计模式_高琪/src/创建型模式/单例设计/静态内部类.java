package 创建型模式.单例设计;

/**
 * author: mxg
 */
public class 静态内部类 {
}

class Singleton_StaticInnerClass {

    private static volatile Singleton_StaticInnerClass instance;

    private Singleton_StaticInnerClass() {
    }

    private static class StaticInnerClass {
        private static final Singleton_StaticInnerClass instance = new Singleton_StaticInnerClass();
    }

    public Singleton_StaticInnerClass getInstance() {

        return StaticInnerClass.instance;
    }
}