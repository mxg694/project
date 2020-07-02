package 尚硅谷.运行时区域.stringtable常量池;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mxg
 *
 -XX:MetaspaceSize=6m  -XX:MaxMetaspaceSize=6m -Xms6m -Xmx6m

 java.lang.OutOfMemoryError: Java heap space

 */
public class String存放的位置 {

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
        int i =0;
        try {
            while (true) {
                //String.intern()   把string字符串放入常量池中
                list.add(String.valueOf(i++).intern());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }
}
