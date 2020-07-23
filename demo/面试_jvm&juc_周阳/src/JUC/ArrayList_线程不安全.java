package JUC;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**     
 * author: mxg
 */
public class ArrayList_线程不安全 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        List<String> list =  Collections.synchronizedList(new ArrayList<>());
//         List<String>copyOnWriteArrayList = new CopyOnWriteArrayList();

        for (int i = 0; i < 50; i++) {
            int finalI = i;
            new Thread(()->{
                list.add(finalI +"");
                System.out.println( Thread.currentThread().getName()+":  " +list);
            }, i+ "").start();
        }
    }


    /**
     *  1、故障现象
     *      java.util.ConcurrentModificationException
     *  2、导致现象
     *       并发争抢修改导致 参考 花名册签名情况
     *  3、解决方案
     *      1、Vector
     *      2、Collections.synchronizedList()
     *      3、new CopyOnWriteArrayList()  写时复制
     *  4 优化建议
     *
     */
}
