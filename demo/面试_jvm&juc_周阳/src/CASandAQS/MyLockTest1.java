package luban.bingfa.CASandAQS;

/**
 * 测试自定义锁的功能
 */
public class MyLockTest1 {
    private MyLock myLock = new MyLock();
    int m = 0;
    public int next() {
        myLock.lock();
        try {
           return m++;
        } finally {
            myLock.unlock();
        }
    }

    public static void main(String[] args) {
        MyLockTest1 test1 = new MyLockTest1();
        Thread[] ts = new Thread[20];
        for (int i=0; i< 20; i++) {
            ts[i] = new Thread(()-> {
                System.out.println(":"+test1.next());
            });
            ts[i].start();
        }
    }

}
