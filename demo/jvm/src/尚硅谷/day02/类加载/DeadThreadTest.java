package 尚硅谷.day02.类加载;

/**
 * author: mxg
 *
 *  证明静态代码块只会被执行一次
 */
public class DeadThreadTest {



    public static void main(String[] args) {
        Runnable r = ()-> {
            System.out.println(Thread.currentThread().getName()+ "：start ");
            DeadThread deadThread = new DeadThread();
            System.out.println(Thread.currentThread().getName()+ "：end ");
        };
        new Thread(r,"t1").start();
        new Thread(r,"t2").start();
    }

}

class DeadThread {
    static {
        System.out.println(Thread.currentThread().getName()+"初始化當前类");
    }
}