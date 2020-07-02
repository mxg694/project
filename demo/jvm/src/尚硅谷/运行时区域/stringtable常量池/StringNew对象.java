package 尚硅谷.运行时区域.stringtable常量池;

/**
 * author: mxg
 *
  new  String("ab")  创建了几个对象
    常量池中不存在 ab 的常量  2个   常量池中 ab 。 new 出来的对象
    常量池中存在 ab 的常量    1个  new
    看字节码

   new String("a") + new String("b")
    对象1： new StringBuilder();
    对象2: new String("a")
    对象3： 常量池中"a"
    对象4： new String("b")
    对象5： 常量池中“b”

    深入分析： StringBuilder.toString();
        new String("ab")
        toString()的调用   字符串常量池中 没有“ab”

 */
public class StringNew对象 {
    public static void main(String[] args) {
        String s = new String("ab");
    }
}
