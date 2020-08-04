package 创建型模式.单例设计.饿汉式;

/**
 * author: mxg
 */
public class 饿汉式_静态变量 {
    public static void main(String[] args) {
        //测试
        Singleton_staticVar instance = Singleton_staticVar.getInstance();
        Singleton_staticVar instance2 = Singleton_staticVar.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

class Singleton_staticVar {
    private final static Singleton_staticVar instance = new Singleton_staticVar();

    //1. 构造器私有化, 外部能new
    private Singleton_staticVar() {

    }

    public static Singleton_staticVar getInstance() {
        return instance;
    }
}
