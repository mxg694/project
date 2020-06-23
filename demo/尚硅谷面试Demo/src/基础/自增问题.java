package 基础;

/**
 * author: mxg
 */
public class 自增问题 {

    public static void main(String[] args) {
        int i = 1;
        // i++ 操作
        // i oldvalue（1）  进入操作数栈
        // i 自增为 2
        // 把 操作数栈中的值（1） 赋值给 i
        i = i++;
        int j = i++;
        int k = i+  ++i * i++;

        System.out.println("i=" + i);  // 4
        System.out.println("j=" + j); // 1
        System.out.println("k=" + k); // 11
    }

}
