package luban.bingfa.CASandAQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义锁
 */
public class MyLock implements Lock {

    private Helper helper = new Helper();

    private class Helper extends AbstractQueuedSynchronizer {

        //获取锁
        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            if (state == 0) {
                //利用cas原理修改state
                if (compareAndSetState(0, arg)) {
                    //设置当前线程占有资源
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }else if (getExclusiveOwnerThread() == Thread.currentThread()) { //锁的可重入性
                setState(getState() + arg);
                return true;
            }
            return false;
        }

        //释放锁
        @Override
        protected boolean tryRelease(int arg) {
            int state = getState() - arg;
            boolean flag = false;
            if (state == 0) {
                setExclusiveOwnerThread(null);
                setState(state);
                return true;
            }
            setState(state);  // 锁的可重入性

            return false;
        }
    }

    @Override
    public void lock() {
        helper.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return helper.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
