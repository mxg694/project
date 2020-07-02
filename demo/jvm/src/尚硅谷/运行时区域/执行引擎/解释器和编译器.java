package 尚硅谷.运行时区域.执行引擎;

/**
 * author: mxg
 *
 *  -Xint ：  纯解释器
 *  -Xcomp  :  纯编译器
 *  -Xmixed  :  混合
 */
public class 解释器和编译器 {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();

        test编译器(1000000000);
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void test编译器(int count) {

        for (int i=1;i<count; i++) {
            for (int j = 0; j <100000 ; j++) {
                if (j % 10 == 0) {
                    break;
                }
            }
        }
    }
}
