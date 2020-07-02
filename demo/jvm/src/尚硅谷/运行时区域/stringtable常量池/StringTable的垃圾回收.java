package 尚硅谷.运行时区域.stringtable常量池;

/**
 * author: mxg

 -Xms15m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails
 */
public class StringTable的垃圾回收 {
    public static void main(String[] args) {
        for (int j =0; j< 100000; j++) {
            String.valueOf(j).intern();
        }
    }
}
