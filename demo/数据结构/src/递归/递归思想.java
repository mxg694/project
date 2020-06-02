package 递归;

/**
 * author: mxg
 */
public class 递归思想 {

    public static void main(String[] args) {
        //通过打印问题，回顾递归调用机制
        test(4, 0);
    }

    /**
     * 打印问题
     * @param n
     */
    public static void test(int n, int t) {
        if (n > 2) {
            test(n - 1, t);
            t++;
            System.out.print("t：" +t + "  ");
        } //else {
        System.out.println("n=" + n);
        // }
    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            // 1 * 2 * 3
            return factorial(n - 1) * n;
        }
    }
}
