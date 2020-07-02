package 黑马.day1.栈;

/**
 * author: mxg
 * <p>
 * 演示 栈内存溢出
 * -
 */
public class 栈内存溢出demo {

    public static  int count ;
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(count);
        }finally {
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }

}
