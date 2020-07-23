package 创建型模式.单例设计.饿汉式;

/**
 * author: mxg
 */
public class 饿汉式_静态代码块 {
    public static void main(String[] args) {

    }
}

class Single_statleVar {
    private static Single_statleVar instance;

    static  {
        instance = new Single_statleVar();
    }

    public static Single_statleVar getInstance() {
        return instance;
    }

}
