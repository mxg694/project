package 尚硅谷.运行时区域.stringtable常量池;

/**
 * author: mxg

 通过断点 debugger 窗口 里的memory 窗口 可以查看string的所有内容
 */
public class String常量池中不会存储相同内容的字符串 {
    public static void main(String[] args) {
        System.out.println("1"); // 2203
        System.out.println("2");//2204
        System.out.println("3");//2205
        System.out.println("4");//2206
        //如下字符串 ，不会被再次加载
        System.out.println("1");  //2206
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }

}
