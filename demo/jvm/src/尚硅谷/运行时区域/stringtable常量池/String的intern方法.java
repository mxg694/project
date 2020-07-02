package 尚硅谷.运行时区域.stringtable常量池;

/**
 * author: mxg
  保证变量s 指向的是字符串常量池中的数据
    一： String s = "mxg";
    二： String s = new String("abc").intern();

 */
public class String的intern方法 {
    public static void main(String[] args) {
        String s = new String("1");
        //调用此方法之前，字符串常量池中已经存在了 “1”
        s.intern();
        String s2 = "1";
        System.out.println(s == s2); //false

        //此操作 字符串常量池中不存在 11
        String s3 = new String("1") + new String("1");
        // jdk7 常量池移到了堆空间中
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4); //true
    }
}
