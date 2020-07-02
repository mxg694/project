package 尚硅谷.运行时区域.虚拟机栈;

/**
 * author: mxg
 */
public class 方法中的局部变量是否线程安全 {
    public static void main(String[] args) {

    }

    /**
     * 局部变量 是线程安全的
     */
    public static void m1() {
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("2");
    }

    /**
     *
     * @param stringBuilder  变量线程  不安全
     * @return
     */
    public static StringBuilder m2(StringBuilder stringBuilder) {
        stringBuilder.append("1");
        stringBuilder.append("2");
        return stringBuilder;
    }

    /**
     *  stringBuilder  有可能线程不安全
     * @return
     */
    public static StringBuilder m3(){
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("2");
        return stringBuilder;
    }

    /**
     * 线程安全
     * @return
     */
    public static String m4(){
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("2");
        return stringBuilder.toString();
    }
}
