package 创建型模式.单例设计.饿汉式;

/**
 * author: mxg
 */
public class 饿汉式_静态变量 {
    public static void main(String[] args) {
        //测试
        Singleton_staticBlock instance = Singleton_staticBlock.getInstance();
        Singleton_staticBlock instance2 = Singleton_staticBlock.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

class Singleton_staticBlock {
    private final static Singleton_staticBlock instance = new Singleton_staticBlock();

    //1. 构造器私有化, 外部能new
    private Singleton_staticBlock() {

    }

    public static Singleton_staticBlock getInstance() {
        return instance;
    }
}
