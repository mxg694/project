package 创建型模式.单例设计.饿汉式;

/**
 * author: mxg
 */
public class 饿汉式_静态代码块 {
    public static void main(String[] args) {

    }
}

class Single_staticBlock {
    private static Single_staticBlock instance;

    static  {
        instance = new Single_staticBlock();
    }

    public static Single_staticBlock getInstance() {
        return instance;
    }

}
