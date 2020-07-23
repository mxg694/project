package luban.bingfa.CASandAQS;

/**
 * 测试锁的可重入
 */
public class MyLockTest2 {

    private MyLock myLock = new MyLock();
    private int m = 0;
    public void  a() {
        myLock.lock();
        System.out.println("a");
        b();
        myLock.unlock();
    }
    public void b() {
        myLock.lock();
        System.out.println("b");
        myLock.unlock();
    }

    public static void main(String[] args) {
        MyLockTest2 myLockTest2 = new MyLockTest2();
        new Thread(()->{
            myLockTest2.a();
        }).start();
    }
}



