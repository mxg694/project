package JUC.cas;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * author: mxg

 解决ABA问题
 *
 */
public class AtomicStampReferenceDemo {
   static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        ABA();
        System.out.println("=======================================");
        ABA_solve();
    }

    /**
     * ABA问题的产生
     */
    public static void ABA() {
        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ABA问题产生");
            System.out.println(  atomicReference.compareAndSet(100,2019)+ "\t finally value:"+ atomicReference.get() );
        }).start();
    }


    public static void ABA_solve() {
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"第一次版本号：" + stamp);
            atomicStampedReference.compareAndSet(100,101, stamp, stamp+1);
            stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"第2次版本号：" + stamp);
            atomicStampedReference.compareAndSet(101,100, stamp, stamp+1);
            stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"第3次版本号：" + stamp);
        },"t3").start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--------------ABA问题解决----------------------");
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() +"第1次版本号：" + stamp);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( Thread.currentThread().getName()+"\t修改成功与否："+
                    atomicStampedReference.compareAndSet(100,2019, stamp, stamp+1));
            System.out.println("最终的版本号：" +atomicStampedReference.getStamp());
            System.out.println("最终的值：" +atomicStampedReference.getReference());

        },"t4").start();
    }
}
